//TODO not mobile responsive

<template>
  <v-app id="inspire" class="inspire">
    <v-main>
      <v-container class="fill-height inspire" >
        <!-- <v-row align="center" justify="center"> -->
          <v-row>
            <v-col cols="1">
              <v-header class="white--text"
                >Requested quotations</v-header
              >
            </v-col>

            <v-col cols="11">
              <v-row>
              <v-card v-for="card in mycards" :key="card" max-width="300px" class="ma-4">
              
    <v-list-item three-line>
      <v-list-item-content>
        <div class="overline mb-4">
          {{card.username}}
        </div>
        <v-list-item-title class="headline mb-1">
          {{card.item}}
        </v-list-item-title>
        <v-list-item-subtitle>{{card.location}}</v-list-item-subtitle>
        <v-list-item-subtitle>{{card.price}}</v-list-item-subtitle>
        <v-list-item-subtitle>{{card.status}}</v-list-item-subtitle>
      </v-list-item-content>
    </v-list-item>
  </v-card>
  </v-row>
            </v-col>
          </v-row>
<!--========================================================================== row ====================================================================== -->
          <v-row>
            <v-col cols="1">
              <v-header class="white--text"
                >Incoming quotation requests</v-header
              >
            </v-col>

            <v-col cols="11">
                <v-row>
              <v-card v-for="card in mycards" :key="card" max-width="300px" class="ma-4">
    <v-list-item three-line>
      <v-list-item-content>
        <div class="overline mb-4">
          {{card.username}}
        </div>
        <v-list-item-title class="headline mb-1">
          {{card.item}}
        </v-list-item-title>
                    <v-btn
        outlined
        rounded
        text
      >
        View sender
      </v-btn>
      </v-list-item-content>
    </v-list-item>

    <v-card-actions>
      <v-btn
        outlined
        rounded
        text
      >
        Send quotation
      </v-btn>
      <v-spacer></v-spacer>
            <v-btn
        outlined
        rounded
        text
      >
        Decline
      </v-btn>
    </v-card-actions>
  </v-card>
  </v-row>
            </v-col>
          </v-row>
          <!-- ======================================================================== row ============================================================== -->
          <v-row>
            <v-col cols="1">
              <v-header class="white--text">Contacted deals</v-header>
            </v-col>

            <v-col cols="11">
              <v-row>
              <v-card v-for="card in mycards" :key="card" max-width="300px" class="ma-4">
    <v-list-item three-line>
      <v-list-item-content>
        <div class="overline mb-4">
          {{card.username}}
        </div>
        <v-list-item-title class="headline mb-1">
          {{card.item}}
        </v-list-item-title>
        <v-list-item-subtitle>{{card.email}}</v-list-item-subtitle>
        <v-list-item-subtitle>{{card.mobile}}</v-list-item-subtitle>
      </v-list-item-content>

    </v-list-item>
  </v-card>
  </v-row>
            </v-col>
          </v-row>
        <!-- </v-row> -->
      </v-container>
    </v-main>
  </v-app>
</template>

<script>
export default {
  data(){
    return{
      mycards: [
          {username: "Tzagu",
          item:"computers",
          location: "All",
          price: 100,
          status: "premium",
          email: "tzaguyapa@gmail.com",
          mobile: 77710234,
          },

          {username: "Zale", //Sea strength
          item: "mobiles",
          location: "All",
          price: 300,
          status: "premium",
          email: "tzaguyapa@gmail.com",
          mobile: 777109226,
          },

          {username: "Naida", //Water nymph
          item: "masks",
          location: "Colombo",
          price: 10.50,
          status: "pending",
          email: "tzaguyapa@gmail.com",
          mobile: 776452105
          },

          {username: "Darya", //The sea
          item: "vegetables",
          location: "All",
          price: 0.00,
          status: "Buyer",
          email: "tzaguyapa@gmail.com",
          mobile: 776452105
          },

          {username: "Fig",
          item:"Cotton",
          location: "All",
          price: 4.55,
          status: "premium",
          email: "tzaguyapa@gmail.com",
          mobile: 777109226
          },
      ]
    }
  }
}
</script>

<style scoped>
.inspire {
  background-color: #36213e;
}
</style>