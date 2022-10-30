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
  import UpdateCompanyStocks from "./UpdateCompanyStocks";
 
class AddCompany extends React.Component {
    constructor(props) {
        super(props);       
        this.state = {         
            id1: "",
            productName: "",
            shortDescription: "",
            detailedDescription: "",
            category: "",
            startingPrice: "",
            bidEndDate: "",
            sellerId: "",          
            hidediv1: false
        };
        this.handleChange = this.handleChange.bind(this);
        this.handleChange1 = this.handleChange1.bind(this);
        this.handleChange2 = this.handleChange2.bind(this);
        this.handleChange3 = this.handleChange3.bind(this);
        this.handleChange4 = this.handleChange4.bind(this);
        this.handleChange5 = this.handleChange5.bind(this);
        this.handleChange6 = this.handleChange6.bind(this);
        this.handleChange7 = this.handleChange7.bind(this);
      this.handleSubmit = this.handleSubmit.bind(this);
    }
    handleChange(val) {    
     this.setState({id1: val.target.value});     
    }
    handleChange1(val) { 
      this.setState({productName: val.target.value});
    }
    handleChange2(val) { 
      this.setState({shortDescription: val.target.value});
    }
    handleChange3(val) { 
      this.setState({detailedDescription: val.target.value});
    }
    handleChange4(val) { 
      this.setState({category: val.target.value});
    }
    handleChange5(val) { 
      this.setState({startingPrice: val.target.value});
    }
    handleChange6(val) { 
      this.setState({bidEndDate: val.target.value});
    }
    handleChange7(val) { 
      this.setState({sellerId: val.target.value});
    }  
       handleSubmit(event) {
         fetch('http://localhost:8080/api/v1.0/market/company/register', {  // Enter your IP address here
      method: 'POST',
      headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
      },
      body: JSON.stringify({
      "id": this.state.id1, 
      "productName": this.state.productName,
      "shortDescription": this.state.shortDescription,
      "detailedDescription": this.state.detailedDescription,
      "category": this.state.category,
      "startingPrice": this.state.startingPrice,    
      "bidEndDate": this.state.bidEndDate,
      "sellerId": Number(this.state.sellerId) // body data type must match "Content-Type" header
      }),
    }).then(response => console.log(response.json()))
    .then(data => {
      alert("Record Inserted Successfully");
    });
    this.setState({      
        hidediv1: true       
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
            
          </ul><div className="App">
              <div hidden={this.state.hidediv1}>
                  <form onSubmit={this.handleSubmit}>
                      <label>
                          Id:
                          <input type="text" onChange={this.handleChange} />
                      </label>
                      <br></br>
                      <label>
                          ProductName:
                          <input type="text" onChange={this.handleChange1} />
                      </label>
                      <br></br>
                      <label>
                          shortDescription:
                          <input type="text" onChange={this.handleChange2} />
                      </label>
                      <br></br>
                      <label>
                          detailedDescription:
                          <input type="text" onChange={this.handleChange3} />
                      </label>
                      <br></br>
                      <label>
                          category:
                          <input type="text" onChange={this.handleChange4} />
                      </label>
                      <br></br>
                      <label>
                          startingPrice:
                          <input type="text" onChange={this.handleChange5} />
                      </label>
                      <br></br>
                      <label>
                          bidEndDate:
                          <input type="text" onChange={this.handleChange6} />
                      </label>
                      <br></br>
                      <label>
                          sellerId:
                          <input type="text" onChange={this.handleChange7} />
                      </label>
                      <br></br>

                      <input type="submit" value="Submit" />
                  </form>
              </div>

          </div></>
  );
}
}
export default AddCompany;