package com.example.demogradlekotlin.domain.onetoone

import com.fasterxml.jackson.annotation.JsonManagedReference
import jakarta.persistence.*
import lombok.AllArgsConstructor
import lombok.Data
import lombok.NoArgsConstructor

@Entity
@Table(name = "orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private var id: Long? = null

    var code: String? = null

    @JsonManagedReference
    @OneToOne(cascade = [CascadeType.ALL], mappedBy = "order", fetch = FetchType.LAZY)
    var billingAddress: Address? = null
}