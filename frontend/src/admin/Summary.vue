<template>
  <v-container>
    <v-row class="fill-height" align="center" justify="center">
      <v-col>
        <v-card min-width="150px">
          <v-card-title> Date range </v-card-title>
          <v-card-text>
            <v-date-picker
              v-model="daterange"
              range
              no-title
              color="#36213e"
              full-width
            ></v-date-picker>
          </v-card-text>
        </v-card>

        <v-row v-for="chart in charts" :key="chart">
          <v-col>
            <v-card min-width="150px">
              <v-card-title>
                {{ chart.title }}
              </v-card-title>
              <v-card-text>
                <v-sparkline
                  :value="chart.value"
                  :gradient="gradient"
                  :smooth="radius || false"
                  :padding="padding"
                  :line-width="width"
                  :stroke-linecap="lineCap"
                  :gradient-direction="gradientDirection"
                  :fill="fill"
                  :type="type"
                  :auto-line-width="autoLineWidth"
                  auto-draw
                ></v-sparkline>
              </v-card-text>
            </v-card>
          </v-col>
        </v-row>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
const gradients = [["#9dbad7", "#3e1963"]];
export default {
  data() {
    return {
      width: 2,
      radius: 10,
      padding: 8,
      lineCap: "round",
      gradient: gradients[0],
      gradientDirection: "bottom",
      gradients,
      fill: false,
      type: "trend",
      autoLineWidth: false,
      daterange: ["", ""],

      charts: [
        {
          title: "Emails sent",
          value: [2, 3, 10, 30, 100, 100, 100, 100, 99],
        },
        {
          title: "Signups",
          value: [0, 2, 5, 9, 5, 10, 3, 5, 0, 0, 1, 8, 2, 9, 0],
        },
        {
          title: "Logins",
          value: [0, 2, 5, 9, 5, 10, 3, 5, 0, 0, 1, 8, 2, 9, 0],
        },
        {
          title: "New Cards",
          value: [0, 2, 5, 9, 5, 10, 3, 5, 0, 0, 1, 8, 2, 9, 0],
        },
      ],
    };
  },
};
</script>

<style>
</style>