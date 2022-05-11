import './App.css';
import Header from './components/Header';
import {BrowserRouter as Router, Route, Routes} from "react-router-dom";
import ChoixUser from "./components/ChoixUser";
import HomePage from "./components/HomePage";
import PageClient from "./components/Client/PageClient";
import AdminAddClient from "./components/Admin/AdminAddClient";
import AdminAddDocuments from "./components/Admin/AdminAddDocuments";
import AdminAddEmprunts from "./components/Admin/AdminAddEmprunts";
import RetourEmprunt from "./components/Admin/RetourEmprunt";
import AddLivre from "./components/Admin/AddLivre";
import AddCd from "./components/Admin/AddCd";
import AddDvd from "./components/Admin/AddDvd";
import RechercheDocument from "./components/RechercheDocument/RechercheDocument";
import RechercheAuteur from "./components/RechercheDocument/RechercheAuteur";
import RechercheCategorie from "./components/RechercheDocument/RechercheCategorie";
import RechercheTitre from "./components/RechercheDocument/RechercheTitre";

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
                        <Route  path="/emprunts" element={<AdminAddEmprunts/>} />
                        <Route  path="/retourEmprunt" element={<RetourEmprunt/>}/>
                        <Route  path="/user" element={<ChoixUser/>}/>
                        <Route  path= "/addLivre" element={<AddLivre/>}/>
                        <Route  path= "/addCd" element={<AddCd/>}/>
                        <Route  path= "/addDvd" element={<AddDvd/>}/>
                        <Route  path="/rechercheDocs" element={<RechercheDocument/>}/>
                        <Route  path="/rechercheTitre" element={<RechercheTitre/>}/>
                        <Route  path="/rechercheCategorie" element={<RechercheCategorie/>}/>
                        <Route  path="/rechercheAuteur" element={<RechercheAuteur/>}/>
                    </Routes>
                </div>
            </Router>
        </div>

    );
}

export default App;
