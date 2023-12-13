package com.example.demogradlekotlin.services.onetoone


import com.example.demogradlekotlin.domain.onetoone.Address
import com.example.demogradlekotlin.domain.onetoone.Order
import com.example.demogradlekotlin.repositories.onetoone.AddressesRepository
import com.example.demogradlekotlin.repositories.onetoone.OrderRepository
import jakarta.transaction.Transactional
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class OneToOneBidirectionalService @Autowired internal constructor(
    orderRepository: OrderRepository,
    addressesRepository: AddressesRepository
) {
    var orderRepository: OrderRepository = orderRepository
    var addressesRepository: AddressesRepository = addressesRepository

    @Transactional
    fun doSomething(): MutableList<Order?> {
        orderRepository.deleteAll()
        addressesRepository.deleteAll()
        val order: Order = Order()
        order.code="H0ck"
        orderRepository.save(order)
        val address: Address = Address()
        address.street="Plaza Mayor"
        order.billingAddress=address
        orderRepository.save(order)
        return orderRepository.findAll()
    }

    @Transactional
    fun doSomethingAddress(): MutableList<Address?> {
        orderRepository.deleteAll()
        addressesRepository.deleteAll()
        val order: Order = Order()
        order.code="H0ck"
        orderRepository.save(order)
        val address: Address = Address()
        address.street="Plaza Mayor"
        order.billingAddress=address
        orderRepository.save(order)
        return addressesRepository.findAll()
    }
}
