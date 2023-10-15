package cl.dv.listacompras.Entidad

import android.os.Parcel
import android.os.Parcelable

data class Tienda(
    val nombre: String?,
    val ubicacion: String?,
    val horario: String?
): Parcelable {
    constructor(parcel: Parcel): this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(nombre)
        parcel.writeString(ubicacion)
        parcel.writeString(horario)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Producto> {
        override fun createFromParcel(parcel: Parcel): Producto {
            return Producto(parcel)
        }

        override fun newArray(size: Int): Array<Producto?> {
            return arrayOfNulls(size)
        }
    }
}
