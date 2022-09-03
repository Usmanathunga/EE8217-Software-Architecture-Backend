import React from "react";
import ReactDOM from "react-dom";
import Chart from "./components/Chart";
import Front from "./components/Front.js";
// import ContactUs from "./components/EmailService";
import axios from "axios";
class App extends React.Component {
  state = {
    chartData: {},
  };

  fetcData = () => {
    axios
      .get(`https://dear-diary-dalin-default-rtdb.firebaseio.com/todo.json`)
      .then((res) => {
        const persons = res.data;
        console.log("persion", persons);
        return persons;
      });
  };
  componentWillMount() {
    var dataSample = this.fetcData();
    this.getChartData();
  }

  getChartData() {
    var dataSample = this.componentWillMount();
    console.log("new Data sa ", dataSample);
    this.setState({
      chartData: {
        labels: [
          "10.05PM",
          "10.05PM",
          "10.10PM",
          "10.15PM",
          "10.20PM",
          "10.25PM",
        ],
        datasets: [
          {
            data: [40, 35, 30, 33, 44, 38],

            backgroundColor: [
              "rgba(255, 99, 132, 0.6)",
              "rgba(54, 162, 235, 0.6)",
              "rgba(255, 206, 86, 0.6)",
              "rgba(75, 192, 192, 0.6)",
              "rgba(153, 102, 255, 0.6)",
              "rgba(255, 159, 64, 0.6)",
              "rgba(255, 99, 132, 0.6)",
            ],
          },
        ],
      },
    });
  }

  render() {
    return (
      <div>
        <div>
          <Front />
        </div>

        <Chart chartData={this.state.chartData} displayLegend={false} />
        {/* <div>
          <ContactUs />
        </div> */}
        <button onClick={this.fetcData}> call function</button>
      </div>
    );
  }
}

const rootElement = document.getElementById("root");
ReactDOM.render(<App />, rootElement);
