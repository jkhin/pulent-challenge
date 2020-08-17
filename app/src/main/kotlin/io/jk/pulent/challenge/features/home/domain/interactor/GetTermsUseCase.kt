package io.jk.pulent.challenge.features.home.domain.interactor

import io.jk.pulent.challenge.features.home.domain.model.Term
import io.jk.pulent.challenge.features.home.domain.repository.TermsRepository

class GetTermsUseCase(
    private val termRepository: TermsRepository
){

    suspend fun getTermsHistory(isAllHistory: Boolean? = true): List<Term> {
        val terms = termRepository.getTermsHistory()
        return if (isAllHistory == true) terms else terms.takeLast(3)
    }


}