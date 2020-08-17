package io.jk.pulent.challenge.features.home.presentation.model.mapper

import io.jk.pulent.challenge.features.home.domain.model.Term
import io.jk.pulent.challenge.features.home.presentation.model.TermHistoryModel

class TermsModelMapper {

    fun map(term: Term): TermHistoryModel = with(term) {
        return@with TermHistoryModel(
            term = this.term
        )
    }

}