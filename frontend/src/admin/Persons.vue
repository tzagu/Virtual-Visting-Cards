<template>
  <v-container>
    <v-row class="fill-height" align="center" justify="center">
      <v-col>
        <v-card min-width="150px" class="ma-2 pa-2">
          <v-card-title>
            #Persons
            <v-spacer></v-spacer>
            {{ personCount }}
          </v-card-title>
          <v-card-text>
              <v-text-field v-model="searchBy" placeholder="Search"></v-text-field>
              <v-row class="fill-height" align="center" justify="center">
                  <v-col>
                      <v-btn class="white--text" color="#36213e" @click="searchByEmail">Email</v-btn>
                  </v-col>
                  <v-spacer></v-spacer>
                  <v-col>
                      <v-btn class="white--text" color="#36213e" @click="searchByName">Name</v-btn>
                  </v-col>
              </v-row>
              <v-row class="fill-height" align="center" justify="center">
                  <v-col>
                      <v-btn class="white--text" color="#36213e" @click="searchByNoOfDeals">#Deals</v-btn>
                  </v-col>
                  <v-spacer></v-spacer>
                  <v-col>
                      <v-btn class="white--text" color="#36213e" @click="searchByNoOfCards">#Cards</v-btn>
                  </v-col>
              </v-row>
            
            <v-date-picker
              v-model="daterange"
              range
              no-title
              color="#36213e"
              full-width
            ></v-date-picker>
            <v-row class="fill-height" align="center" justify="center">
                  <v-col>
                      <v-btn class="white--text" color="#36213e" @click="searchByInactive">Inactive</v-btn>
                  </v-col>
                  <v-spacer></v-spacer>
                  <v-col>
                      <v-btn class="white--text" color="#36213e" @click="searchBySignup">Signed up</v-btn>
                  </v-col>
              </v-row>
              <v-textarea auto-grow :value="personData" outlined></v-textarea>
              <v-card-actions>
          
                <v-col>
                    <v-text-field v-model="deleteThisPerson" placeholder="Person ID"></v-text-field>
                </v-col>
                <v-spacer></v-spacer>
                <v-col>
                    <v-btn class="white--text" color="red" @click="deletePerson">
                        Delete
                    </v-btn>
                </v-col>
           
            </v-card-actions>
          </v-card-text>
        </v-card>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
export default {
    data(){
        return{
            personCount: 406,
            searchBy: "",
            personData: {id: 1, name: "tzagu", cards: [{id: 2, name: "masks"}, {id: 4, name: "gloves"}]}, //before assigning values to this property, you may have to convert them into String
            deleteThisPerson: 0,
            daterange: [], //preferebly and array of two strings
        }
    },
    methods: {
        searchByEmail(){},
        searchByName(){},//many names may result. handle carefully
        deletePerson(){},
        searchByInactive(){}, //has Not signedup, created cards or sent emails during this period
        searchBySignup(){}, //signedup within this period
        searchByNoOfDeals(){},
        searchByNoOfCards(){},
    }

}
</script>

<style>

</style>