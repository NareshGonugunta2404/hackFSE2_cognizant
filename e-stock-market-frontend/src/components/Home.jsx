import React from "react";
import { Link } from "react-router-dom";
  
const Home = () => {
  return (
    <div>
      <h1 class="pl-3">E STOCK MARKET</h1>
      <h1 class="pr-3">Heading Here</h1>
      <br />
      <ul>
        <li>
          {/* Endpoint to route to Home component */}
          <Link to="/">Home</Link>
        </li>
        <li>
          {/* Endpoint to route to About component */}
          <Link to="/ShowCompanies">Show Companies</Link>
        </li>
        <li>
          {/* Endpoint to route to Contact Us component */}
          <Link to="/DeleteCompany">Delete Company</Link>
        </li>
        <li>
          {/* Endpoint to route to Contact Us component */}
          <Link to="/AddCompany">Add Company</Link>
        </li>
        <li>
          {/* Endpoint to route to Contact Us component */}
          <Link to="/UpdateCompanyStocks">Update Company Stocks</Link>
        </li>
      
      
      </ul>
    </div>
  );
};
  
export default Home;