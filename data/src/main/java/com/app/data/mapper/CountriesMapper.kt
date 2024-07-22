package com.app.data.mapper

import com.app.data.base.Mapper
import com.app.data.network.entities.CountryDTO
import com.app.domain.entities.CountryInfo

class CountriesMapper : Mapper<List<CountryDTO>, List<CountryInfo>> {
    override fun map(input: List<CountryDTO>): List<CountryInfo> {
        return input.map {
            CountryInfo(
                name = it.name.common.orEmpty(),
                population = it.population ?: 0,
                region = it.region.orEmpty(),
                area = it.area ?: 0.0,
                flag = it.flags.png.orEmpty(),
                coatOfArms = it.coatOfArms.png.orEmpty(),
                maps = it.maps.googleMaps.orEmpty(),
                capital = it.capital.joinToString(",")
            )
        }
    }
}