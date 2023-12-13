package com.example.demogradlekotlin.domain.onetoone

import jakarta.persistence.*
import lombok.AllArgsConstructor
import lombok.Data
import lombok.NoArgsConstructor

@Entity(name = "Phone")
@Data
@NoArgsConstructor
@AllArgsConstructor
class Phone {
    @Id
    @GeneratedValue
    private val id: Long? = null

    @Column(name = "`number`")
    var number: String? = null

    @OneToOne
    @JoinColumn(name = "details_id")
    var details: PhoneDetails? = null
}
