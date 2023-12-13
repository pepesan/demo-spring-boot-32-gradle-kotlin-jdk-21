package com.example.demogradlekotlin.services.onetoone


import com.example.demogradlekotlin.domain.onetoone.Phone
import com.example.demogradlekotlin.domain.onetoone.PhoneDetails
import com.example.demogradlekotlin.repositories.onetoone.PhoneDetailsRepository
import com.example.demogradlekotlin.repositories.onetoone.PhoneRepository
import jakarta.transaction.Transactional
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class OneToOneService @Autowired internal constructor(
    phoneRepository: PhoneRepository,
    phoneDetailsRepository: PhoneDetailsRepository
) {
    var phoneRepository: PhoneRepository = phoneRepository
    var phoneDetailsRepository: PhoneDetailsRepository = phoneDetailsRepository

    @Transactional
    fun doSomething(): MutableList<Phone?> {
        val phone: Phone = Phone()
        phone.number="923124578"
        phoneRepository.save(phone)
        val phoneDetails: PhoneDetails = PhoneDetails()
        phoneDetails.provider="PepePhone"
        phoneDetails.technology="5G"
        phoneDetailsRepository.save(phoneDetails)
        phone.details=phoneDetails
        phoneRepository.save(phone)
        return phoneRepository.findAll()
    }
}