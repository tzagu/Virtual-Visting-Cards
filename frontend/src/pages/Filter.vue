<template>
  <v-app class="inspire">
    <v-main>
      <v-container>
        <v-card>
          <v-form class="ma-12 pa-8">
            <v-row>
              <v-col>
                <h3>Filter results</h3>
                <v-select :items="locations" label="Location"></v-select>
                <v-select :items="locations" label="Category"></v-select>
                <v-select :items="locations" label="Item"></v-select>
                <v-select :items="locations" label="Brand"></v-select>
                <v-subheader>Price range</v-subheader>

                <v-range-slider
                  v-model="range"
                  :max="max"
                  :min="min"
                  hide-details
                  class="align-center"
                >
                  <template v-slot:prepend>
                    <v-text-field
                      :value="range[0]"
                      class="mt-0 pt-0"
                      hide-details
                      single-line
                      type="number"
                      style="width: 60px"
                      @change="$set(range, 0, $event)"
                    ></v-text-field>
                  </template>
                  <template v-slot:append>
                    <v-text-field
                      :value="range[1]"
                      class="mt-0 pt-0"
                      hide-details
                      single-line
                      type="number"
                      style="width: 60px"
                      @change="$set(range, 1, $event)"
                    ></v-text-field>
                  </template>
                </v-range-slider>
                <v-select :items="locations" label="Partner type"></v-select>

                <v-btn absolute right class="white--text" color="#36213e"
                    >Search</v-btn
                  >
              </v-col>
            </v-row>
          </v-form>
        </v-card>
      </v-container>
    </v-main>
  </v-app>
</template>

<script>
export default {
  data() {
    return {
      min: 0,
      max: 10000,
      slider: 40,
      range: [5, 500],
      locations: [
        "Ampara",
        "Anuradhapura",
        "Badulla",
        "Batticaloa",
        "Colombo",
        "Galle",
        "Gampaha",
        "Hambantota",
        "Jaffna",
        "Kalutara",
        "Kandy",
        "Kegalle",
        "Kilinochchi",
        "Kurunegala",
        "Mannar",
        "Matale",
        "Matara",
        "Moneragala",
        "Mullaitivu",
        "Nuwara Eliya",
        "Polonnaruwa",
        "Puttalam",
        "Ratnapura",
        "Trincomalee",
        "Vavuniya",
      ],
    };
  },
};
</script>

<style scoped>
.inspire {
  background-color: #36213e;
}
</style>