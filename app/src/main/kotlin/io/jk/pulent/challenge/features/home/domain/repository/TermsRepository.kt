package io.jk.pulent.challenge.features.home.domain.repository

import io.jk.pulent.challenge.features.home.domain.model.Term

interface TermsRepository {

    suspend fun getTermsHistory(): List<Term>

}