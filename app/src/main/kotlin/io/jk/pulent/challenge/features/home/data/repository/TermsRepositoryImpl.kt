package io.jk.pulent.challenge.features.home.data.repository

import io.jk.pulent.challenge.features.home.data.mapper.TermsMapper
import io.jk.pulent.challenge.features.home.domain.model.Term
import io.jk.pulent.challenge.features.home.domain.repository.TermsRepository
import io.jk.pulent.challenge.features.search.data.datasource.database.TermsLocalStorage

class TermsRepositoryImpl(
    private val termsLocalStorage: TermsLocalStorage,
    private val termsMapper: TermsMapper
): TermsRepository {

    override suspend fun getTermsHistory(): List<Term> {
        return termsLocalStorage.getTermsHistory().map(termsMapper::map)
    }

}