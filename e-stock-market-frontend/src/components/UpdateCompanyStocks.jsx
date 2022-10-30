import React from "react";
import {
    BrowserRouter as Router,
    Routes,
    Route,
  } from "react-router-dom";
  import { Link } from "react-router-dom";
  import Home from "./Home";
  import DeleteCompany from "./DeleteCompany";
  import ShowCompanies from "./ShowCompanies";
  import AddCompany from "./AddCompany";
 
class UpdateCompanyStocks extends React.Component {
    constructor(props) {
        super(props);       
        this.state = { 
            items:[],        
            id2: "",
            bidAmount: "",
            buyerEmailld: "",                   
            hidediv1: false
        };
        this.handleChange = this.handleChange.bind(this);
        this.handleChange1 = this.handleChange1.bind(this);
        this.handleChange2 = this.handleChange2.bind(this);      
      this.handleSubmit = this.handleSubmit.bind(this);
    }
    handleChange(val) {    
     this.setState({id2: val.target.value});     
    }
    handleChange1(val) { 
      this.setState({buyerEmailld: val.target.value});
    }
    handleChange2(val) { 
      this.setState({bidAmount: val.target.value});
    }
       handleSubmit(event) {
         fetch('http://localhost:8080/api/v1.0/stockmarket/company/update/'+this.state.id2+'/'+this.state.buyerEmailld+'/'+this.state.bidAmount, {  // Enter your IP address here
      method: 'PUT',
      headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
      },
      body: JSON.stringify({
      "id": this.state.id2, 
      "bidAmount": this.state.bidAmount,
      "buyerEmailld": this.state.buyerEmailld     
      }),
    }).then((res) => res.json())
    .then((json) => {                                   
        if(json.id2!==undefined){    
            alert("Record updated succesfully");               
          this.setState({
              items:json,            
              hidediv1: false
            });
          }               
          else {                        
            alert("Record1 updated succesfully");                   
          }      
    })    
    .catch(error => {
        
        console.error('There was an error!', error);
    }); 
   
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
                  <Link to="ShowCompanies">Show Companies</Link>
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
          <div className="App">
              <div hidden={this.state.hidediv1}>
                  <form onSubmit={this.handleSubmit}>
                      <label>
                          Id:
                          <input type="text" onChange={this.handleChange} />
                      </label>
                      <br></br>
                      <label>
                      BuyerEmailId:
                          <input type="text" onChange={this.handleChange1} />
                      </label>
                      <br></br>
                      <label>
                      BidAmt:
                          <input type="text" onChange={this.handleChange2} />
                      </label>
                     
                      <input type="submit" value="Submit" />
                  </form>
              </div>

          </div></>
  );
}
}
export default UpdateCompanyStocks;