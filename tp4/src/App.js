import logo from './logo.svg';
import './App.css';
import Header from './components/Header';
import Clients from "./components/Clients";
import HomePage from "./components/HomePage";
import Footer from "./components/Footer";
import Documents from "./components/Documents";
import ChoixUser from "./components/ChoixUser";
import {BrowserRouter as Router, Route, Switch} from "react-router-dom";
import Emprunts from "./components/Emprunts";
import RetourEmprunt from "./components/RetourEmprunt";
import Routage from "./components/Routage";

function App() {
    return (
        <div>
            <div className="App-header">
                <Header title="Bibliotheque"/>
            </div>
            <Routage />
        </div>

    );
}

export default App;
