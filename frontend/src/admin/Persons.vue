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
                      <v-btn class="white--text" color="#36213e" @click="searchByNoOfDeals">#Deals</v-btn>
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
                      <v-btn class="white--text" color="#36213e" @click="searchByInactive">Last active in</v-btn>
                  </v-col>
                  <v-spacer></v-spacer>
                  <v-col>
                      <v-btn class="white--text" color="#36213e" @click="searchBySignup">Signedup in</v-btn>
                  </v-col>
              </v-row>
              <v-textarea auto-grow :value="personData" v-model="personData" outlined></v-textarea>
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
    <v-snackbar
    :value="snackbar"
      v-model="snackbar"
      :timeout="timeout"
      shaped
      top
      color="blue-grey"
      transition="fab-transition"
    >
      {{ text }}
    </v-snackbar>
  </v-container>
</template>

<script>
import Axios from 'axios'

export default {
    data(){
        return{
            personCount: 406,
            searchBy: "",
            personData: "", //before assigning values to this property, you may have to convert them into String
            deleteThisPerson: 0,
            daterange: [], //preferebly and array of two strings
            resultSet: [],
            snackbar: false,
      text: "",
      timeout: 5000,
        }
    },
    methods: {
        searchByEmail(){
          Axios.get("/partner/" + this.searchBy).then((response) => {
            this.personData = JSON.stringify(response.data, null, "\t")
          }).catch((error) => {
            console.log(error)
          })
        },
        deletePerson(){
          this.text = "use postman tzagu !"
          this.snackbar = true
        },
        searchByInactive(){
          this.personData = ""
          this.resultSet = []
          Axios.get("/getactivities").then((response) => {
            for(let i = 0; i < response.data.length; i++){
              if(response.data[i].date >= this.daterange[0] && response.data[i].date <= this.daterange[1]){
                this.resultSet.push(response.data[i])
              }
            }
            this.personData = JSON.stringify(this.resultSet, null, "\t")
          }).catch((error) => {
            console.log(error)
          })
        }, 
        searchBySignup(){
          this.personData = ""
          this.resultSet = []
          Axios.get("/person").then((response) => {
            for(let i = 0; i < response.data.length; i++){
              if(response.data[i].joinedDate >= this.daterange[0] && response.data[i].joinedDate <= this.daterange[1]){
                this.resultSet.push(response.data[i])
              }
            }
            this.personData = JSON.stringify(this.resultSet, null, "\t")
          }).catch((error) => {
            console.log(error)
          })
        }, 
        searchByNoOfDeals(){
          this.personData = ""
          this.resultSet = []
          Axios.get("/deals").then((response) => {
            for(let i = 0; i < response.data.length; i++){
              let userId = response.data[i].personId
              let dealCount = 0
              for(let j = 0; j < response.data.length; j++){
                if(response.data[j].personId === userId){
                  dealCount++;
                }
              }
              if(dealCount >= parseInt(this.searchBy)){
                this.resultSet.push(response.data[i])
              }
            }
            this.personData = JSON.stringify(this.resultSet, null, "\t")
          }).catch((error) => {
            console.log(error)
          })
        },
    },
    mounted(){
      Axios.get("/person").then((response) => {
        this.personCount = response.data.length
      })
    }

}
</script>

<style>

</style>