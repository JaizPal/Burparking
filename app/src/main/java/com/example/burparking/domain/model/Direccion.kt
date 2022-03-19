package com.example.burparking.domain.model

import com.example.burparking.data.database.entities.DireccionEntity
import com.example.burparking.data.model.direccion.DireccionModel

data class Direccion(
    val id: Long,
    val lat: Double,
    val lon: Double,
    val numero: String?,
    var calle: String?,
    val codigoPostal: String?
) {
    override fun toString(): String {
//        return (calle ?: "") + " " + (numero ?: "") + " " + (codigoPostal ?: "")
//        return if (!calle.isNullOrEmpty()) {
//            if (!numero.isNullOrEmpty()) {
//                if (!codigoPostal.isNullOrEmpty()) {
//                    "$calle $numero $codigoPostal"
//                } else {
//                    "$calle $numero"
//                }
//            } else {
//                calle
//            }
//        } else {
//            " "
//        }
        return if(!calle.isNullOrEmpty()) {
            if(!numero.isNullOrEmpty()) {
                if(!codigoPostal.isNullOrEmpty()) {
                    calle!! + " " + numero + " " + codigoPostal
                } else {
                    calle!! + " " + numero
                }
            } else {
                calle!!
            }
        } else {
            " "
        }
    }
}

fun DireccionModel.toDomain() = Direccion(id, lat, lon, tags.numero, tags.calle, tags.codigoPostal)
fun DireccionEntity.toDomain() = Direccion(id, lat, lon, numero, calle, codigoPostal)