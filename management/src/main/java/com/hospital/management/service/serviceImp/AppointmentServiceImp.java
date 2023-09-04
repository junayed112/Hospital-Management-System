package com.hospital.management.service.serviceImp;

import com.hospital.management.entity.Appointment;
import com.hospital.management.entity.DoctorTimeSlot;
import com.hospital.management.error.AppointmentBookedException;
import com.hospital.management.error.IdNotFoundException;
import com.hospital.management.repository.AppointmentRepository;
import com.hospital.management.repository.DoctorTimeSlotRepository;
import com.hospital.management.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class AppointmentServiceImp implements AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;
    @Autowired
    private DoctorTimeSlotRepository doctorTimeSlotRepository;

    @Override
    public Appointment bookAppointment(Appointment appointment) {
        DoctorTimeSlot doctorTimeSlot = doctorTimeSlotRepository.findDoctorIdByTimeSlot(
                appointment.getDoctorId(), appointment.getTimeSlotId(),appointment.getDate());
        if(doctorTimeSlot == null){
            throw new IdNotFoundException("The Doctor id or timeslot id isn't present here");
        }
        if(doctorTimeSlot.getAppointmentBooked().equals("Yes")){
            throw new AppointmentBookedException("time Slot isn't available now");
        }
        doctorTimeSlot.setAppointmentBooked("Yes");
        return appointmentRepository.save(appointment);
    }

    @Override
    public void cancelAppointment(Long id) {
        Optional<Appointment> appointment = appointmentRepository.findById(id);
        if(!appointment.isPresent()){
            throw new IdNotFoundException("Id doesn't exist");
        }
        Long doctorId = appointment.get().getDoctorId();
        Long timeSlotId = appointment.get().getTimeSlotId();
        Date date = appointment.get().getDate();
        DoctorTimeSlot doctorTimeSlot = doctorTimeSlotRepository.findDoctorIdByTimeSlot(doctorId,timeSlotId,date);
        doctorTimeSlot.setAppointmentBooked("No");
        doctorTimeSlotRepository.save(doctorTimeSlot);
        appointment.get().setStatus("canceled");
        appointmentRepository.save(appointment.get());
    }
}
