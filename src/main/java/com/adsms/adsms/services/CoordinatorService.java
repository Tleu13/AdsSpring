package com.adsms.adsms.services;

import com.adsms.adsms.model.*;
import com.adsms.adsms.repositories.*;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CoordinatorService {

    private PatientRepository patientRepository;
    private StaffRepository staffRepository;
    private DiagnosisRepository diagnosisRepository;
    private ResearchRepository researchRepository;
    private EventPrototypeRepository eventPrototypeRepository;

    private ProtocolRepository protocolRepository;
    private EventRepository eventRepository;
    private TaskRepository taskRepository;

    public CoordinatorService(PatientRepository patientRepository, StaffRepository staffRepository,
                              DiagnosisRepository diagnosisRepository, ResearchRepository researchRepository,
                              EventPrototypeRepository eventPrototypeRepository, ProtocolRepository protocolRepository,
                              EventRepository eventRepository, TaskRepository taskRepository) {
        this.patientRepository = patientRepository;
        this.staffRepository = staffRepository;
        this.diagnosisRepository = diagnosisRepository;
        this.researchRepository = researchRepository;
        this.eventPrototypeRepository = eventPrototypeRepository;
        this.protocolRepository = protocolRepository;
        this.eventRepository = eventRepository;
        this.taskRepository = taskRepository;
    }

    public List<Patient> getAll() {
        List<Patient> adverseEvents = new ArrayList<>();
        this.patientRepository.findAll().forEach(adverseEvents::add);
        return adverseEvents;
    }

    public void createStaff(Staff staff) {
        staffRepository.save(staff);
    }


    public void createPatientAndDiagnosis(Patient patient, Diagnosis diagnosis) {

        patientRepository.save(patient);
        diagnosisRepository.save(diagnosis);

    }

    public void createResearch(Research research) {

        List<EventPrototype> eventPrototypes = new ArrayList<>();
        List<Protocol> taskPrototypesForEvent;
        research = researchRepository.save(research);
        eventPrototypeRepository.findAll().forEach(eventPrototypes::add);

        for (EventPrototype prototype : eventPrototypes) {
            Event event = new Event();
            event.setEventDate(research.getEnrollmentDate().plusDays(prototype.getEventInterval()));
            if (event.getEventDate().isBefore(java.time.LocalDate.now())) {
                event.setEventProgress(100);
            } else {
                event.setEventProgress(0);
            }
            event.setEventPrototype(prototype);
            event.setResearch(research);
            event = eventRepository.save(event);
            taskPrototypesForEvent = protocolRepository.findAllByEventPrototype(prototype.getEventPrototypeId());


            for (Protocol protocol : taskPrototypesForEvent) {
                Task task = new Task();
             //   System.out.println("_____________________" + protocol.toString());
                TaskPrototype taskPrototype = new TaskPrototype();
                taskPrototype.setTaskPrototypeId(protocol.getTaskPrototype());

                task.setTaskPrototype(taskPrototype);
                task.setEvent(event);
                if (event.getEventProgress() == 0) {
                    task.setTaskProgress(0);
                } else {
                    task.setTaskProgress(100);
                }
                taskRepository.save(task);
            }

        }

        recalculateResearchProgress(research);

    }

    private void recalculateResearchProgress(Research research) {
        double result;
        List<Event> events;
        int countCompletedTasks = 0;
        events = eventRepository.findAllByResearch(research);
        for (Event event : events) {

            List<Task> tasks = taskRepository.findTaskProgressByEvent_EventId(event.getEventId());
            System.out.println("_____________________"+tasks.toString());
            for (Task progress : tasks) {
                if (progress.getTaskProgress() == 100) {
                    countCompletedTasks++;
                }
            }
        }
        result = countCompletedTasks / 341.0 * 100;
        research.setResearchProgress(result);
        researchRepository.save(research);
        //flush
    }

}