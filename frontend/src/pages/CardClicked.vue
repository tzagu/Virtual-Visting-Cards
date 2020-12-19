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
              <v-rating
                :value="itemperson.profileRate"
                background-color="grey"
                color="yellow accent-4"
                dense
                readonly
                size="16"
              ></v-rating>
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
        </v-col>
        
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
        </v-col>
      </v-row>

      <v-card-actions>
        <v-row>
          <v-col>
            <div class="text-center">
              <v-dialog v-model="dialog" width="500">
                <template v-slot:activator="{ on, attrs }">
                  <!-- main card button -->
                  <v-btn
                    class="white--text"
                    color="#36213e"
                    v-bind="attrs"
                    v-on="on"
                    >Contact Partner</v-btn
                  >
                </template>
                <!-- call or email options card -->
                <v-card>
                  <v-card-title class="inspire white--text">
                    Contact partner
                  </v-card-title>

                  <v-card-text>
                    We recommend sending an email to negotiate a comfortable
                    date and time for your partner. You may also request a
                    drafted quotation. First impression matters!
                  </v-card-text>

                  <v-divider></v-divider>

                  <v-card-actions>
                    <template>
                      <div class="text-center">
                        <v-dialog v-model="dialog3">
                          <template v-slot:activator="{ on, attrs }">
                            <v-btn
                              v-bind="attrs"
                              v-on="on"
                              color="#36213e"
                              class="white--text"
                            >
                              Send an email
                            </v-btn>
                          </template>

                          <v-card class="pa-8">
                            <v-card-title class="inspire white--text">
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
                                <v-btn
                                  color="#36213e"
                                  class="white--text"
                                  type="submit"
                                >
                                  Send
                                </v-btn>
                                <v-spacer></v-spacer>
                                <v-btn
                                  color="#36213e"
                                  class="white--text"
                                  @click="dialog3 = false"
                                >
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
                            <v-btn
                              v-bind="attrs"
                              v-on="on"
                              color="#36213e"
                              class="white--text"
                            >
                              Call
                            </v-btn>
                          </template>
                          <v-row align="center" justify="center">
                            <v-col>
                              <v-card class="pa-8">
                                <v-card-title class="headline grey lighten-2"
                                  >Contact via mobile</v-card-title
                                >
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
              <v-col>
                <div class="text-center">
                  <v-rating
                    v-model="Cardrating"
                    :value="Cardrating"
                    background-color="grey"
                    color="yellow accent-4"
                    dense
                    hover
                    size="35"
                  ></v-rating>
                </div>
              </v-col>

        </v-row>
      </v-card-actions>
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
    Cardrating: 0,
    selectedCardId: 0,
    userEmail: "",
    userName: "",
    subject: "B Card Request", //subject of the email to contact a partner
    emailBody:
      "Good day !\n, I'm interested in constructing a business partnership with you upon one of your B cards . Please send me a comfortable time and a date to schedule a discussion.\n Thank you",
    dialog: false,
    dialog2: false,
    dialog3: false,
    itemperson: {
      personId: 0,
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
      profileRate: 0,
      compareCardRating: 0, //current rate of the card. before leaving page, card rating will be compared to this and if different, new value is posted
    },
    responseItemPersonArr: [],
    responsePersonArr: [],
  }),
  methods: {
    sendMail() {
      Axios.post("/contactpartner", {
        to: this.itemperson.email,
        replyTo: this.userEmail,
        subject: this.subject,
        text: this.emailBody,
      }).then((response) => {
        Axios.post("/savedeal", {
          //get newly created deal
        }).then((responseDeal) => {
          //get deals of itemperson
          Axios.get("/itemperson/"+ this.$store.state.cardData.id).then((responseItemPerson) => {
            for(let i = 0; i < responseItemPerson.data.deals.length; i++){
              this.responseItemPersonArr.push(responseItemPerson.data.deals[i])
            }
          //add new deal id
            this.responseItemPersonArr.push(responseDeal)
          //PUT updated array
          Axios.put("/adddeal/"+ this.$store.state.cardData.id, {
            deals: this.responseItemPersonArr
          }).catch((error) => {
            console.log(error)
          })
          }).catch((error) => {
            console.log(error)
          });
          Axios.put("/updateactivity/" + this.$store.state.user.email,{
              activity: "Card"
            }).catch((error) => {
              console.log(error)
            })
          //get deals of person
          Axios.get("/all/" + this.itemperson.personId).then((responsePerson) => {
            for(let n = 0; n < responsePerson.data.deals.length; n++){
              this.responsePersonArr.push(responsePerson.data.deals[n])
            }
          //add new deal id
            this.responsePersonArr.push(responseDeal)
          }).catch((error) => {
            console.log(error)
          })
          //PUT updated array
          Axios.put("/addpartner/"+ this.itemperson.personId, {
            deals: this.responsePersonArr
          }).catch((error) => {
            console.log(error)
          })
        }).catch((error) => {
            console.log(error)
          })
      })
      
      .catch((error) => {
        console.log(error);
      });

      this.dialog3 = false;
      this.dialog = false;
      this.text = "Mail sent !";
      this.snackbar = true;
    },
  },

  mounted() {
    this.selectedCardId = this.$store.state.cardData.id;
    Axios.get("/itemperson/" + this.selectedCardId)
      .then((response) => {
        this.itemperson.personId = response.data.person.id
        this.itemperson.itemName = response.data.item.name;
        this.itemperson.price = response.data.price;
        this.itemperson.location = response.data.deliverTo;
        this.itemperson.personName = response.data.person.name;
        this.itemperson.email = response.data.person.email;
        this.itemperson.mobile1 = response.data.person.mobile1;
        this.itemperson.mobile2 = response.data.person.mobile2;
        this.itemperson.landline = response.data.person.landline;
        this.itemperson.status = response.data.person.status;
        this.itemperson.profileRate = response.data.person.rating;
        this.itemperson.compareCardRating = response.data.rating;
        this.Cardrating = response.data.rating;
      })
      .catch((error) => {
        console.log(error);
      });
    this.userEmail = this.$store.state.user.email;
    this.userName = this.$store.state.user.name;
  },

  beforeRouteLeave(to, from, next) {
    if (this.Cardrating !== this.itemperson.compareCardRating) {
      let i = (this.Cardrating + this.itemperson.compareCardRating) / 2;
      Axios.put("/rateCard/" + this.selectedCardId, {
        rating: i,
      })
        .then((response) => {
          next();
        })
        .catch((error) => {
          console.log(error);
        });
    } else {
      next();
    }
  },
};
</script>

<style scoped>
.inspire {
  background-color: #36213e;
}
</style>