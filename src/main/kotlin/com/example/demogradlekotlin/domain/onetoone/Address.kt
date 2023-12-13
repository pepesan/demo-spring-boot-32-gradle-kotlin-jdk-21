package com.example.demogradlekotlin.domain.onetoone

import com.fasterxml.jackson.annotation.JsonBackReference
import jakarta.persistence.*
import lombok.AllArgsConstructor
import lombok.Data
import lombok.NoArgsConstructor

@Entity
@Table(name = "addresses")
@Data
@NoArgsConstructor
@AllArgsConstructor
class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private var id: Long? = null

    @Column(name = "street")
    var street: String? = null


    @JsonBackReference
    @OneToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    private val order: Order? = null
}