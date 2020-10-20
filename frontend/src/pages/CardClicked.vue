<template>
  <v-app id="inspire" class="inspire">
    <v-main>
      <v-container class="fill-height inspire" fluid>
        <v-row align="center" justify="center">
          <v-card class="pa-10 fill-height">
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
                          <v-card-title class="headline grey lighten-2">
                            Contact partner
                          </v-card-title>

                          <v-card-text>
                            We recommend sending an email to negotiate a
                            comfortable date and time for your partner. First
                            impression matters!
                          </v-card-text>

                          <v-divider></v-divider>

                          <v-card-actions>
                            <v-btn color="primary" text @click="dialog = false">
                              Send an email
                            </v-btn>
                            <v-spacer></v-spacer>
                            <v-btn color="primary" text @click="dialog = false">
                              Contact via mobile
                            </v-btn>
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
                      <v-dialog v-model="dialog2" width="500">
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
                            <v-btn
                              color="primary"
                              text
                              @click="dialog2 = false"
                            >
                              send via email
                            </v-btn>
                          </v-card-actions>
                        </v-card>
                      </v-dialog>
                    </div>
                  </v-col>
                </v-row>
              </v-col>
            </v-row>
          </v-card>
        </v-row>
      </v-container>
    </v-main>
  </v-app>
</template>

<script>
import Axios from "axios";

export default {
  data: () => ({
    dialog: false,
    dialog2: false,
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
  mounted() {
    Axios.get("/itemperson/" + this.$store.state.cardData.id).then(
      (response) => {
        this.itemperson.itemName = response.data.item.name;
        this.itemperson.price = response.data.price;
        this.itemperson.location = response.data.deliverTo;
      }
    ),
      Axios.get("/person").then((response) => {
        for (var i = 0; i < response.data.length; i++) {
          for (var j = 0; j < response.data[i].itemPersonList.length; j++) {
            if (
              response.data[i].itemPersonList[j].id ===
              this.$store.state.cardData.id
            ) {
              this.itemperson.personName = response.data[i].name;
              this.itemperson.email = response.data[i].email;
              this.itemperson.mobile1 = response.data[i].mobile1;
              this.itemperson.mobile2 = response.data[i].mobile2;
              this.itemperson.landline = response.data[i].landLine;
              this.itemperson.status = response.data[i].status;
            }
          }
        }
      });
  },
};
</script>

<style scoped>
.inspire {
  background-color: #36213e;
}
</style>