import React from "react";
import {
    BrowserRouter as Router,
    Routes,
    Route,
  } from "react-router-dom";
  import { Link } from "react-router-dom";
  import Home from "./Home";
  import DeleteBids from "./DeleteBids";
  import ShowBids from "./ShowBids";
  import AddProduct from "./AddProduct";
 
class UpdateBid extends React.Component {
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
         fetch('http://localhost:8080/e-auction/api/v1/buyer/update-bid/'+this.state.id2+'/'+this.state.buyerEmailld+'/'+this.state.bidAmount, {  // Enter your IP address here
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
              <Route exact path="/" component={Home} />
              <Route path="/ShowBids" component={ShowBids} />
              <Route path="/DeleteBids" component={DeleteBids} />
              <Route path="/Addproduct" component={AddProduct} />
              
          </Routes>
      </Router><ul>
              <li>
                  {/* Endpoint to route to Home component */}
                  <Link to="/">Home</Link>
              </li>
              <li>
                  {/* Endpoint to route to Contact Us component */}
                  <Link to="DeleteBids">Delete Bids</Link>
              </li>
              <li>
                  {/* Endpoint to route to Contact Us component */}
                  <Link to="ShowBids">Show Bids</Link>
              </li>
              <li>
                  {/* Endpoint to route to Contact Us component */}
                  <Link to="AddProduct">Add Product</Link>
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
export default UpdateBid;