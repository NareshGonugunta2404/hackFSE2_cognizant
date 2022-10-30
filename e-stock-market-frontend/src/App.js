import React from 'react'
import applogo from './images/estockmarket1.png';
import {
  BrowserRouter as Router,
  Routes,
  Route,
} from "react-router-dom";
import Home from "./components/Home";
import ShowCompanies from "./components/ShowCompanies";
import DeleteCompany from "./components/DeleteCompany";
import AddCompany from "./components/AddCompany";
import UpdateCompanyStocks from "./components/UpdateCompanyStocks";
class StockMarket extends React.Component {  
      // Constructor     
     render() {    
      return (
        <><img src={applogo} alt="e-stockmarket" /><><Router>
          <Routes>
            <Route exact path="/" element={<Home/>} />
            <Route path="/ShowCompanies" element={<ShowCompanies/>} />
            <Route path="/DeleteCompany" element={<DeleteCompany/>} />  
            <Route path="/AddCompany" element={<AddCompany/>} />
            <Route path="/UpdateCompanyStocks" element={<UpdateCompanyStocks/>} />
          </Routes>
        </Router></></>
  );
}
}  
export default StockMarket;