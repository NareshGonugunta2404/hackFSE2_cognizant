import React from "react";
import {
  BrowserRouter as Router,
  Routes,
  Route,
} from "react-router-dom";
import { Link } from "react-router-dom";
import Home from "./Home";
import DeleteCompany from "./DeleteCompany";
import AddCompany from "./AddCompany";
import UpdateCompanyStocks from "./UpdateCompanyStocks";

class ShowCompanies extends React.Component {
  constructor(props) {
    super(props);    
    this.state = {
      bidid: null,
      hidediv: true ,
      hidediv1: true ,
        items: [],
        id1: "",
        productName: "",
        textInput: "",
        shortDescription: "",
        detailedDescription: "",
        category: "",
        startingPrice: "",
        bidEndDate: "",
        sellerId: ""               
    };
    this.handleChange = this.handleChange.bind(this);
  }
  handleChange({ target }) {
    this.setState({
      [target.name]: target.value
    });
  }
  showBids()  {
    fetch(
      "http://localhost:8080/api/v1.0/market/company/info/"+this.state.bidid)
                .then((res) => res.json())
                .then((json) => {                                   
                    if(json.id!==undefined){                       
                      this.setState({
                          items:json,
                          hidediv: false,
                          hidediv1: true
                        });
                      }               
                      else {                        
                        this.setState({ hidediv: true, hidediv1: false }) 
                      }
                  
                })        
                .catch(error => this.setState({ hidediv: true, hidediv1: false }));
  }
  render() {   
  return (
    <><Router>
      <Routes>
            <Route exact path="/" element={<Home/>} />
            <Route path="/ShowCompanies" element={<ShowCompanies/>} />
            <Route path="/DeleteCompany" element={<DeleteCompany/>} />  
            <Route path="/AddCompany" element={<AddCompany/>} />
            <Route path="/UpdateCompanyStocks" element={<UpdateCompanyStocks/>} />
      </Routes>
    </Router>
    <ul>
        <li>
          {/* Endpoint to route to Home component */}
          <Link to="/">Home</Link>
        </li>
         <li>
          {/* Endpoint to route to Contact Us component */}
          <Link to="DeleteCompany">Delete Company</Link>
        </li>
        <li>
          {/* Endpoint to route to Contact Us component */}
          <Link to="AddCompany">Add Company</Link>
        </li>
        <li>
          {/* Endpoint to route to Contact Us component */}
          <Link to="UpdateCompanyStocks">Update Company Stocks</Link>
        </li>
      </ul>
    <div>
        <label>
          Id:
          <input type="text" name="bidid"
            placeholder="Enter BidId..."
            value={this.state.bidid} onChange={this.handleChange} />
        </label>
        <br></br>

        <button onClick={() => this.showBids()}>ShowBids</button>
        <div hidden={this.state.hidediv}>
          <h1> Fetch data from an api in react </h1>

          ProductId: {this.state.items.id}<br></br>
          Product_Name: {this.state.items.productName}<br></br>
          Short_Description: {this.state.items.shortDescription}<br></br>
          Detailed_Description: {this.state.items.detailedDescription} <br></br>
          Category: {this.state.items.category}<br></br>
          Starting_Price: {this.state.items.startingPrice}<br></br>
          BidEndDate: {this.state.items.bidEndDate} <br></br>
          SellerId: {this.state.items.sellerId} <br></br>
        </div>
        <div hidden={this.state.hidediv1}> ProductId: {this.state.items.id} is not found </div>
      </div></>
  );
}
}
export default ShowCompanies;