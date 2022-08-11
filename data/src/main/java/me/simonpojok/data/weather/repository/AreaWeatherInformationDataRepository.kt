package me.simonpojok.data.weather.repository

//import me.simonpojok.authentication.AuthenticationKeyProvider
//import me.simonpojok.remote.remote.OpenWeatherService
//import me.simonpojok.domain.weather.model.AreaWeatherConditionDomainModel
//import me.simonpojok.domain.weather.model.CoordinateDomainModel
//import me.simonpojok.domain.weather.repository.AreaWeatherInformationRepository

//class AreaWeatherInformationDataRepository(
//    private val openWeatherService: me.simonpojok.remote.remote.OpenWeatherService,
//    private val authenticationKeyProvider: AuthenticationKeyProvider
//) : AreaWeatherInformationRepository {
//    override suspend fun getAreaWeatherCondition(coordinateDomainModel: CoordinateDomainModel): AreaWeatherConditionDomainModel {
//        return openWeatherService.getCurrentWeatherData(
//            lat = coordinateDomainModel.lat,
//            log = coordinateDomainModel.lon,
//            apiKey = authenticationKeyProvider.getAuthenticationKey().apiKey
//        )
//    }
//}
