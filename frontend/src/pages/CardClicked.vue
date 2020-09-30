<template>
  <v-app id="inspire" class="inspire">
    <v-main>
      <v-container class="fill-height" fluid>
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
                      :value="itemperson.name"
                    ></v-text-field>
                  </v-col>
                </v-row>

                <v-row>
                  <v-col cols="4">
                    <v-subheader>Category:</v-subheader>
                  </v-col>
                  <v-col cols="8">
                    <v-text-field
                    solo
                    flat
                    readonly
                      :value="itemperson.category"
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
                    <v-btn class="white--text" color="#36213e">Contact Partner</v-btn>
                  </v-col>
                  </v-row
              ></v-col>
              <v-col
                ><v-row>
                  <v-col cols="4">
                    <v-subheader></v-subheader>
                  </v-col>
                  <v-col cols="8">
                    <v-text-field dark
                      
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
                      :value="itemperson.item"
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
                    <v-btn absolute right class="white--text" color="#36213e">Request Quotation</v-btn>
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
export default {
  data: () => ({
      itemperson:{
          name: "YMS Upeksha",
          category: "Software",
          item: "Solutions and services",
          price: "",
          location: "Any",
      }
  }),
};
</script>

<style scoped>
.inspire {
  background-color: #36213e;
}
</style>