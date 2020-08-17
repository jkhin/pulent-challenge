package io.jk.pulent.challenge.features.home.data.mapper

import io.jk.pulent.challenge.features.home.domain.model.Term
import io.jk.pulent.challenge.features.search.data.datasource.database.entity.TermEntity

class TermsMapper {

    fun map(entity: TermEntity): Term = Term(
        term = entity.term
    )

}