<template>
<v-row align="center" justify="center" class="fill-height mt-6">
    <v-col>
    <v-sheet class="AdminHome">
        <v-tabs v-model="text" fixed-tabs>
            <v-tab v-for="page in pages" :key="page.text">
                {{page.text}}
            </v-tab>
        </v-tabs>
        <v-tabs-items v-model="text">
            <v-tab-item v-for="page in pages" :key="page.text">
                <v-card flat>
                    <v-card-text>
                        <component v-bind:is="page.content"></component>    
                    </v-card-text>
                </v-card>
            </v-tab-item>
        </v-tabs-items>
    </v-sheet>
    </v-col>
</v-row>
</template>

<script>
import Summary from './Summary'
import Items from './Items'
import Persons from './Persons'
import Cards from './Cards'

export default {
    components: {
        Summary,
        Items,
        Persons,
        Cards
    },
    data(){
        return{
            text: null,
            pages: [{text: "Summary", content: Summary}, {text: "Items", content: Items}, {text:"Persons", content: Persons}, {text:"Cards", content: Cards}]
        }
    }

}
</script>

<style>
.AdminHome{
    font-family:Cambria, Cochin, Georgia, Times, 'Times New Roman', serif
}
</style>