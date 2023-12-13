package com.example.demogradlekotlin.services.manytomany

import com.example.demogradlekotlin.domain.manytomany.Etiqueta
import com.example.demogradlekotlin.domain.manytomany.Noticia
import com.example.demogradlekotlin.repositories.manytomany.EtiquetaRepository
import com.example.demogradlekotlin.repositories.manytomany.NoticiaRepository
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
class ManyToManyUnidirectionalService @Autowired constructor(
    noticiaRepository: NoticiaRepository,
    etiquetaRepository: EtiquetaRepository
) {
    private val noticiaRepository: NoticiaRepository = noticiaRepository

    private val etiquetaRepository: EtiquetaRepository = etiquetaRepository

    fun doSomething(): MutableList<Noticia?> {
        val noticia: Noticia = Noticia()
        noticia.titulo="Noticia 1"
        noticiaRepository.save(noticia)
        val etiqueta: Etiqueta = Etiqueta()
        etiqueta.nombre="Etiqueta 1"
        etiquetaRepository.save(etiqueta)
        noticia.etiquetas.add(etiqueta)
        noticiaRepository.save(noticia)
        return noticiaRepository.findAll()
    }
}
