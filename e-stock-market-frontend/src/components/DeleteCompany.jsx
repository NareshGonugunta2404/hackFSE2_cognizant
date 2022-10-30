import React from "react";
import {
    BrowserRouter as Router,
    Routes,
    Route,
  } from "react-router-dom";
  import { Link } from "react-router-dom";
  import Home from "./Home";
  import ShowCompanies from "./ShowCompanies";
  import AddCompany from "./AddCompany";
  import UpdateCompanyStocks from "./UpdateCompanyStocks";
  
 
  
class DeleteCompany extends React.Component {
  constructor(props) {
    super(props);    
    this.state = {
      bidid: null,
      hidediv: true             
    };
    this.handleChange = this.handleChange.bind(this);
  }
  handleChange({ target }) {
    this.setState({
      [target.name]: target.value
    });
  }
  deleteBids() {    
    fetch("http://localhost:8080/api/v1.0/market/company/delete/"+this.state.bidid, {
      method: 'DELETE',  
      
  }).then((data1) => {  
    this.setState({        
        hidediv: false        
    });     
      })
      .catch(function (error) {
    console.log(error);
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
      </Router><ul>
              <li>
                  {/* Endpoint to route to Home component */}
                  <Link to="/">Home</Link>
              </li>
              <li>
                  {/* Endpoint to route to Contact Us component */}
                  <Link to="ShowShowCompaniesBids">Show Companies</Link>
              </li>
              <li>
                  {/* Endpoint to route to Contact Us component */}
                  <Link to="AddCompany">Add Company</Link>
              </li>
              <li>
                  {/* Endpoint to route to Contact Us component */}
                  <Link to="UpdateCompanyStocks">Update Company Stocks</Link>
              </li> 
            
          </ul><div>
              <label>
                  BidId:
                  <input type="text" name="bidid"
                      placeholder="Enter BidId..."
                      value={this.state.bidid} onChange={this.handleChange} />
              </label><button onClick={() => this.deleteBids()}>DeleteBids</button>
              <br></br>
              <div hidden={this.state.hidediv}>
                  ProductId: {this.state.bidid} is successfully deleted<br></br>
              </div>
          </div></>
  );
}
}
export default DeleteCompany;