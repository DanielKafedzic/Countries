package com.example.example

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class Country(
    @SerializedName("name") var name: Name? = Name(),
    @SerializedName("tld") var tld: ArrayList<String> = arrayListOf(),
    @SerializedName("cca2") var cca2: String? = null,
    @SerializedName("ccn3") var ccn3: String? = null,
    @SerializedName("cca3") var cca3: String? = null,
    @SerializedName("cioc") var cioc: String? = null,
    @SerializedName("independent") var independent: Boolean? = null,
    @SerializedName("status") var status: String? = null,
    @SerializedName("unMember") var unMember: Boolean? = null,
    @SerializedName("idd") var idd: Idd? = Idd(),
    @SerializedName("capital") var capital: ArrayList<String> = arrayListOf(),
    @SerializedName("altSpellings") var altSpellings: ArrayList<String> = arrayListOf(),
    @SerializedName("region") var region: String? = null,
    @SerializedName("subregion") var subregion: String? = null,
    @SerializedName("languages") var languages: Languages? = Languages(),
    @SerializedName("latlng") var latlng: ArrayList<Int> = arrayListOf(),
    @SerializedName("landlocked") var landlocked: Boolean? = null,
    @SerializedName("borders") var borders: ArrayList<String> = arrayListOf(),
    @SerializedName("area") var area: Int? = null,
    @SerializedName("flag") var flag: String? = null,
    @SerializedName("maps") var maps: Maps? = Maps(),
    @SerializedName("population") var population: Int? = null,
    @SerializedName("fifa") var fifa: String? = null,
    @SerializedName("car") var car: Car? = Car(),
    @SerializedName("timezones") var timezones: ArrayList<String> = arrayListOf(),
    @SerializedName("continents") var continents: ArrayList<String> = arrayListOf(),
    @SerializedName("flags") var flags: Flags? = Flags(),
    @SerializedName("coatOfArms") var coatOfArms: CoatOfArms? = CoatOfArms(),
    @SerializedName("startOfWeek") var startOfWeek: String? = null,
    @SerializedName("capitalInfo") var capitalInfo: CapitalInfo? = CapitalInfo()
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readParcelable(Name::class.java.classLoader),
        parcel.createStringArrayList() ?: arrayListOf(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Boolean::class.java.classLoader) as? Boolean,
        parcel.readString(),
        parcel.readValue(Boolean::class.java.classLoader) as? Boolean,
        parcel.readParcelable(Idd::class.java.classLoader) ?: Idd(),
        parcel.createStringArrayList() ?: arrayListOf(),
        parcel.createStringArrayList() ?: arrayListOf(),
        parcel.readString(),
        parcel.readString(),
        parcel.readParcelable(Languages::class.java.classLoader) ?: Languages(),
        parcel.createIntArray()?.toList() as? ArrayList<Int> ?: arrayListOf(),
        parcel.readValue(Boolean::class.java.classLoader) as? Boolean,
        parcel.createStringArrayList() ?: arrayListOf(),
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readParcelable(Maps::class.java.classLoader) ?: Maps(),
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readParcelable(Car::class.java.classLoader) ?: Car(),
        parcel.createStringArrayList() ?: arrayListOf(),
        parcel.createStringArrayList() ?: arrayListOf(),
        parcel.readParcelable(Flags::class.java.classLoader) ?: Flags(),
        parcel.readParcelable(CoatOfArms::class.java.classLoader) ?: CoatOfArms(),
        parcel.readString(),
        parcel.readParcelable(CapitalInfo::class.java.classLoader) ?: CapitalInfo()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeParcelable(name, flags)
        parcel.writeStringList(tld)
        parcel.writeString(cca2)
        parcel.writeString(ccn3)
        parcel.writeString(cca3)
        parcel.writeString(cioc)
        parcel.writeValue(independent)
        parcel.writeString(status)
        parcel.writeValue(unMember)
        parcel.writeParcelable(idd, flags)
        parcel.writeStringList(capital)
        parcel.writeStringList(altSpellings)
        parcel.writeString(region)
        parcel.writeString(subregion)
        parcel.writeParcelable(languages, flags)
        parcel.writeIntArray(latlng.toIntArray())
        parcel.writeValue(landlocked)
        parcel.writeStringList(borders)
        parcel.writeValue(area)
        parcel.writeString(flag)
        parcel.writeParcelable(maps, flags)
        parcel.writeValue(population)
        parcel.writeString(fifa)
        parcel.writeParcelable(car, flags)
        parcel.writeStringList(timezones)
        parcel.writeStringList(continents)
        parcel.writeParcelable(flags, flags)
        parcel.writeParcelable(coatOfArms, flags)
        parcel.writeString(startOfWeek)
        parcel.writeParcelable(capitalInfo, flags)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Country> {
        override fun createFromParcel(parcel: Parcel): Country {
            return Country(parcel)
        }

        override fun newArray(size: Int): Array<Country?> {
            return arrayOfNulls(size)
        }
    }
}
