package cl.dv.listacompras.Entidad

import android.os.Parcelable
import android.os.Parcel

data class Producto(
    val nombre: String?,
    val especificacion: String?,
    val cantidad: Int,
    val precio: Int
) : Parcelable {
    constructor(parcel: Parcel): this(
        parcel.readString(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readInt()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(nombre)
        parcel.writeString(especificacion)
        parcel.writeInt(cantidad)
        parcel.writeInt(precio)
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
