package com.example.pokedex.pokemon_detail

import com.airbnb.epoxy.TypedEpoxyController
import com.example.model.PokemonDetailView

class PokemonDetailController: TypedEpoxyController<PokemonDetailView>() {

    override fun buildModels(data: PokemonDetailView?) {
        data ?: return

        thumbnail {
            id("thumbnail_${data.id}") // idは一意にする必要がある
            imageUrl(data.imageUrl)
        }
        parameter {
            id("name_${data.id}")
            label("Name")
            value(data.name)
        }
        parameter {
            id("height_${data.id}")
            label("Height")
            value(data.height.toString())
        }
        parameter {
            id("weight_${data.id}")
            label("Weight")
            value(data.weight.toString())
        }
        parameter {
            id("type1_${data.id}")
            label("Type1")
            value(data.type1.type.name)
        }
        parameter {
            id("type2_${data.id}")
            label("Type2")
            value(data.type2?.type?.name ?: "Nothing")
        }
        parameter {
            id("ability1_${data.id}")
            label("Ability1")
            value(data.ability1.abilityX.name)
        }
        parameter {
            id("ability2_${data.id}")
            label("Ability2")
            value(data.ability2?.abilityX?.name ?: "Nothing")
        }
        parameter {
            id("hidden_ability_${data.id}")
            label("HiddenAbility")
            value(data.hiddenAbility?.abilityX?.name ?: "Nothing")
        }
    }
}