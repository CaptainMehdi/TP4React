import './App.css';
import Header from './components/Header';
import {BrowserRouter as Router, Route, Routes} from "react-router-dom";
import ChoixUser from "./components/ChoixUser";
import HomePage from "./components/HomePage";
import PageClient from "./components/Client/PageClient";
import AdminAddClient from "./components/Admin/AdminAddClient";
import AdminAddDocuments from "./components/Admin/AdminAddDocuments";
import Emprunts from "./components/Admin/Emprunts";
import RetourEmprunt from "./components/Admin/RetourEmprunt";
import AddLivre from "./components/Admin/AddLivre";
import AddCd from "./components/Admin/AddCd";
import AddDvd from "./components/Admin/AddDvd";

function App() {

    return (
        <div>
            <div className="App-header">
                <Header title="Bibliotheque"/>
            </div>
            <Router>
                <div>
                    <Routes>
                        <Route  path="/" element={<ChoixUser/>}/>
                        <Route  path="/home" element={<HomePage/>}/>
                        <Route  path="/client" element={<PageClient/>}/>
                        <Route  path="/clients" element={<AdminAddClient/>}/>
                        <Route  path="/documents" element={<AdminAddDocuments/>}/>
                        <Route  path="/emprunts" element={<Emprunts/>} />
                        <Route  path="/retourEmprunt" element={<RetourEmprunt/>}/>
                        <Route  path="/user" element={<ChoixUser/>}/>
                        <Route  path= "/addLivre" element={<AddLivre/>}/>
                        <Route  path= "/addCd" element={<AddCd/>}/>
                        <Route  path= "/addDvd" element={<AddDvd/>}/>

                    </Routes>
                </div>
            </Router>
        </div>

    );
}

export default App;
