<template>
  <v-row align="center" justify="center">
    <v-card class="pa-4 mx-1 fill-height">
      <v-row>
        <v-col
          ><v-row>
            <v-col cols="4">
              <v-subheader>Posted by:</v-subheader>
            </v-col>
            <v-col cols="8">
              <v-text-field
                solo
                flat
                readonly
                :value="itemperson.personName"
              ></v-text-field>
            </v-col>
          </v-row>

          <v-row>
            <v-col cols="4">
              <v-subheader>Profile rate:</v-subheader>
            </v-col>
            <v-col cols="8">
              <v-text-field
                solo
                flat
                readonly
                :value="itemperson.status"
              ></v-text-field>
            </v-col>
          </v-row>

          <v-row>
            <v-col cols="4">
              <v-subheader>Location:</v-subheader>
            </v-col>
            <v-col cols="8">
              <v-text-field
                solo
                flat
                readonly
                :value="itemperson.location"
              ></v-text-field>
            </v-col>
          </v-row>

          <v-row>
            <v-col cols="12">
              <div class="text-center">
                <v-dialog v-model="dialog" width="500">
                  <template v-slot:activator="{ on, attrs }">
                    <v-btn
                      class="white--text"
                      color="#36213e"
                      v-bind="attrs"
                      v-on="on"
                      >Contact Partner</v-btn
                    >
                  </template>

                  <v-card>
                    <v-card-title class="headline purple darken-3">
                      Contact partner
                    </v-card-title>

                    <v-card-text>
                      We recommend sending an email to negotiate a comfortable
                      date and time for your partner. First impression matters!
                    </v-card-text>

                    <v-divider></v-divider>

                    <v-card-actions>
                      <template>
                        <div class="text-center">
                          <v-dialog v-model="dialog3">
                            <template v-slot:activator="{ on, attrs }">
                              <v-btn v-bind="attrs" v-on="on" color="#36213e" class="white--text">
                                Send an email
                              </v-btn>
                            </template>

                            <v-card class="pa-8">
                              <v-card-title class="headline purple darken-3">
                                Contact partner
                              </v-card-title>

                              <v-form @submit.prevent="sendMail">
                                <v-text-field
                                  prepend-icon="mdi-account"
                                  label="Name"
                                  required
                                  :value="userName"
                                  disabled
                                ></v-text-field>
                                <v-text-field
                                  prepend-icon="mdi-email"
                                  label="Your email"
                                  required
                                  :value="userEmail"
                                  disabled
                                ></v-text-field>
                                <v-text-field
                                  prepend-icon="mdi-message"
                                  label="Email Subject"
                                  required
                                  :value="subject"
                                  v-model="subject"
                                ></v-text-field>
                                <v-textarea
                                  label="Email Body"
                                  prepend-icon="mdi-message-text"
                                  v-model="emailBody"
                                ></v-textarea>
                                <v-divider></v-divider>
                                <v-row>
                                <v-btn color="#F50057" class="white--text" type="submit">
                                  Send
                                </v-btn>
                                <v-spacer></v-spacer>
                                <v-btn color="#36213e" class="white--text" @click="dialog3 = false">
                                  Cancel
                                </v-btn>
                                </v-row>
                              </v-form>
                            </v-card>
                          </v-dialog>
                        </div>
                      </template>

                      <v-spacer></v-spacer>



                      <template>
                        <div>
                          <v-dialog v-model="dialog4">
                            <template v-slot:activator="{ on, attrs }">
                              <v-btn v-bind="attrs" v-on="on" color="#36213e" class="white--text">
                                Call
                              </v-btn>
                            </template>
                            <v-row align="center" justify="center">
                              <v-col>
                            <v-card class="pa-8">
                              <v-card-title class="headline grey lighten-2">Contact via mobile</v-card-title>
                              <v-text-field
                                  prepend-icon="mdi-cellphone"
                                  label="Mobile 1"
                                  :value="itemperson.mobile1"
                                ></v-text-field>
                                <v-text-field
                                  prepend-icon="mdi-cellphone"
                                  label="Mobile 2"
                                  :value="itemperson.mobile2"
                                ></v-text-field>
                                <v-text-field
                                  prepend-icon="mdi-phone-classic"
                                  label="Work"
                                  :value="itemperson.landline"
                                ></v-text-field>
                            </v-card>
                            </v-col>
                            </v-row>
                          </v-dialog>
                        </div>
                      </template>




                    </v-card-actions>
                  </v-card>
                </v-dialog>
              </div>
            </v-col>
          </v-row></v-col
        >
        <v-col
          ><v-row>
            <v-col cols="4">
              <v-subheader>Date:</v-subheader>
            </v-col>
            <v-col cols="8">
              <v-text-field
                solo
                flat
                readonly
                :value="itemperson.date"
              ></v-text-field>
            </v-col>
          </v-row>

          <v-row>
            <v-col cols="4">
              <v-subheader>Item:</v-subheader>
            </v-col>
            <v-col cols="8">
              <v-text-field
                solo
                flat
                readonly
                :value="itemperson.itemName"
              ></v-text-field>
            </v-col>
          </v-row>

          <v-row>
            <v-col cols="4">
              <v-subheader>Price:</v-subheader>
            </v-col>
            <v-col cols="8">
              <v-text-field
                solo
                flat
                readonly
                :value="itemperson.price"
              ></v-text-field>
            </v-col>
          </v-row>

          <v-row>
            <v-col cols="12">
              <div class="text-center">
                <!-- <v-dialog v-model="dialog2" width="500">
                  <template v-slot:activator="{ on, attrs }">
                    <v-btn
                      class="white--text"
                      color="#36213e"
                      v-bind="attrs"
                      v-on="on"
                      >Request Quotation</v-btn
                    >
                  </template>

                  <v-card>
                    <v-card-title class="headline grey lighten-2">
                      Request quotation
                    </v-card-title>

                    <v-card-text>
                      Default quotation request message here
                    </v-card-text>

                    <v-divider></v-divider>

                    <v-card-actions>
                      <v-spacer></v-spacer>
                      <v-btn color="primary" text @click="dialog2 = false">
                        send via email
                      </v-btn>
                    </v-card-actions>
                  </v-card>
                </v-dialog> -->
              </div>
            </v-col>
          </v-row>
        </v-col>
      </v-row>
    </v-card>
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
  </v-row>
</template>

<script>
import Axios from "axios";

export default {
  data: () => ({
        snackbar: false,
      text: "",
      timeout: 5000,
      
    selectedCardId: 0,
    userEmail: "",
    userName: "",
    subject: "B Card Request", //subject of the email to contact a partner
    emailBody: "Good day !\n, I'm interested in constructing a business partnership with you upon one of your B cards . Please send me a comfortable time and a date to schedule a discussion.\n Thank you",
    dialog: false,
    dialog2: false,
    dialog3: false,
    itemperson: {
      personName: "YMS Upeksha",
      status: " ",
      date: "01/10/2020",
      itemName: "Solutions and services",
      price: 10,
      location: "Any",
      email: "tzaguyapa@gmail.com",
      mobile1: "0777109226",
      mobile2: "0786034977",
      landline: "0112729729",
    },
  }),
  methods: {
    sendMail() {
      Axios.post("/contactpartner", {
        to: this.itemperson.email,
        replyTo: this.userEmail,
        subject: this.subject,
        text: this.emailBody,
      })
        .catch((error) => {
          console.log(error);
        });
    
      this.dialog3 = false;
      this.dialog = false;
      this.text = "Mail sent !"
            this.snackbar = true
      //this.$router.push({name: "ItemPersonCards"})
    },
  },

  mounted() {
    console.log("selected card id from component, from store, item name from component, item name from axios request")
    console.log(this.selectedCardId)
    console.log(this.$store.state.cardData.id)
    console.log(this.itemperson.itemName)
    
    this.selectedCardId = this.$store.state.cardData.id
    Axios.get("/itemperson/" + this.selectedCardId).then(
      (response) => {
        console.log(response.data.item.name)
        this.itemperson.itemName = response.data.item.name;
        this.itemperson.price = response.data.price;
        this.itemperson.location = response.data.deliverTo;
        this.itemperson.personName = response.data.person.name;
        this.itemperson.email = response.data.person.email;
        this.itemperson.mobile1 = response.data.person.mobile1;
        this.itemperson.mobile2 = response.data.person.mobile2;
        this.itemperson.landline = response.data.person.landline;
        this.itemperson.status = response.data.person.status;
      }
    )
    .catch((error) => {
          console.log(error);
        })
    this.userEmail = this.$store.state.user.email
    this.userName = this.$store.state.user.name
    // Axios.get("/person").then((response) => {
    //   for (var i = 0; i < response.data.length; i++) {
    //     for (var j = 0; j < response.data[i].itemPersonList.length; j++) {
    //       if (
    //         response.data[i].itemPersonList[j].id ===
    //         this.$store.state.cardData.id
    //       ) {
    //         this.itemperson.personName = response.data[i].name;
    //         this.itemperson.email = response.data[i].email;
    //         this.itemperson.mobile1 = response.data[i].mobile1;
    //         this.itemperson.mobile2 = response.data[i].mobile2;
    //         this.itemperson.landline = response.data[i].landLine;
    //         this.itemperson.status = response.data[i].status;
    //       }
    //     }
    //   }
    // });
  },
};
</script>

<style scoped>
.inspire {
  background-color: #36213e;
}
</style>