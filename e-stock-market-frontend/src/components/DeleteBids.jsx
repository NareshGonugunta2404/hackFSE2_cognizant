import React from "react";
import {
    BrowserRouter as Router,
    Routes,
    Route,
  } from "react-router-dom";
  import { Link } from "react-router-dom";
  import Home from "./Home";
  import ShowBids from "./ShowBids";
  import AddProduct from "./AddProduct";
  import UpdateBid from "./UpdateBid";
  
 
  
class DeleteBids extends React.Component {
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
    fetch("http://localhost:8080/e-auction/api/v1/seller/delete/"+this.state.bidid, {
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
              <Route exact path="/" component={Home} />
              <Route path="/ShowBids" component={ShowBids} />
              <Route path="/AddProduct" component={AddProduct} />             
              <Route path="/UpdateBid" component={UpdateBid} /> 
              
          </Routes>
      </Router><ul>
              <li>
                  {/* Endpoint to route to Home component */}
                  <Link to="/">Home</Link>
              </li>
              <li>
                  {/* Endpoint to route to Contact Us component */}
                  <Link to="ShowBids">Show Bids</Link>
              </li>
              <li>
                  {/* Endpoint to route to Contact Us component */}
                  <Link to="AddProduct">Add Product</Link>
              </li>
              <li>
                  {/* Endpoint to route to Contact Us component */}
                  <Link to="UpdateBid">UpdateBid</Link>
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
export default DeleteBids;