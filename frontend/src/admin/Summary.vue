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
              @change="Filtersearch"
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
import Axios from "axios";

const gradients = [["#9dbad7", "#3e1963"]];
export default {
  data() {
    return {
      width: 2,
      radius: 10,
      padding: 2,
      lineCap: "round",
      gradient: gradients[0],
      gradientDirection: "bottom",
      gradients,
      fill: false,
      type: "trend",
      autoLineWidth: false,
      daterange: [],

      charts: [
        {
          title: "Active",
          value: [],
          activeDays: [],
        },
        {
          title: "New Cards",
          value: [],
          createdDates: [],
        },
        {
          title: "Emails sent",
          value: [],
          emailedDates: []
        },
        {
          title: "Signups",
          value: [],
          joinedDates: []
        },
      ],
    };
  },
  methods: {
    Filtersearch() {
      this.charts[0].value = [];
      this.charts[0].activeDays = [];
      //Activities from activity table datewise count
      Axios.get("/getactivities").then((response) => {
        for (let i = 0; i < response.data.length; i++) {
          if (
            response.data[i].date >= this.daterange[0] &&
            response.data[i].date <= this.daterange[1]
          ) {
            this.charts[0].activeDays.push(response.data[i].date);
          }
        }
        let count = 1;
        for (let x = 0; x < this.charts[0].activeDays.length; x++) {
          if (
            this.charts[0].activeDays[x] === this.charts[0].activeDays[x + 1]
          ) {
            count++;
          } else {
            this.charts[0].value.push(count);
            count = 1;
          }
        }
      });
      //new cards from store.state table datewise count
      for (let n = 0; n < this.$store.state.allItemPersonCards.length; n++) {
        if(this.$store.state.allItemPersonCards[n].date >= this.daterange[0] && this.$store.state.allItemPersonCards[n].date <= this.daterange[1]){
          this.charts[1].createdDates.push(this.$store.state.allItemPersonCards[n].date)
        }
      }
      let count = 1;
        for (let x = 0; x < this.charts[1].createdDates.length; x++) {
          if (
            this.charts[1].createdDates[x] === this.charts[1].createdDates[x + 1]
          ) {
            count++;
          } else {
            this.charts[1].value.push(count);
            count = 1;
          }
        }

      //emails sent from my deals
      Axios.get("/deals").then((response) => {
        for (let i = 0; i < response.data.length; i++) {
          if (
            response.data[i].date >= this.daterange[0] &&
            response.data[i].date <= this.daterange[1]
          ) {
            this.charts[2].emailedDates.push(response.data[i].date);
          }
        }
        let count = 1;
        for (let x = 0; x < this.charts[2].emailedDates.length; x++) {
          if (
            this.charts[2].emailedDates[x] === this.charts[2].emailedDates[x + 1]
          ) {
            count++;
          } else {
            this.charts[2].value.push(count);
            count = 1;
          }
        }
      });

      //signups from person table (joined date)
            Axios.get("/person").then((response) => {
        for (let i = 0; i < response.data.length; i++) {
          if (
            response.data[i].joinedDate >= this.daterange[0] &&
            response.data[i].joinedDate <= this.daterange[1]
          ) {
            this.charts[3].joinedDates.push(response.data[i].joinedDate);
          }
        }
        let count = 1;
        for (let x = 0; x < this.charts[3].joinedDates.length; x++) {
          if (
            this.charts[3].joinedDates[x] === this.charts[3].joinedDates[x + 1]
          ) {
            count++;
          } else {
            this.charts[3].value.push(count);
            count = 1;
          }
        }
      });

    },
  },
};
</script>

<style>
</style>