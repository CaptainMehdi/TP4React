import logo from './logo.svg';
import './App.css';
import Header from './components/Header';
import Routage from "./components/Routage";
import {BrowserRouter as Router, Route, Switch} from "react-router-dom";
import ChoixUser from "./components/ChoixUser";
import HomePage from "./components/HomePage";
import PageClient from "./components/Client/PageClient";
import AdminAddClient from "./components/Admin/AdminAddClient";
import AdminAddDocuments from "./components/Admin/AdminAddDocuments";
import Emprunts from "./components/Admin/Emprunts";
import RetourEmprunt from "./components/Admin/RetourEmprunt";
import {useState} from "react";
import Client from "./components/Client";
import Clients from "./components/Clients";

function App() {
    const [clients, setClients] = useState([])
    const [showClients, setShowClient] = useState(false)

    const addClient = async (client) => {
        const res = await fetch('http://localhost:3001/todos',
            {
                method: 'POST',
                headers: {
                    'Content-type': 'application/json',
                },
                body: JSON.stringify(client)
            })
        const data = await res.json()
        setClients([...clients, data])

    }

    return (
        <div>
            <div className="App-header">
                <Header title="Bibliotheque"/>
            </div>
            <Router>
                <div>
                    <Switch>
                        <Route exact path="/" component={ChoixUser}/>
                        <Route exact path="/home" component={HomePage}/>
                        <Route exact path="/client" component={PageClient}/>
                        <Route exact path="/clients" render={(props )=> (
                            <>
                                <AdminAddClient onAdd={addClient()} />
                            </>
                        )}/>
                        <Route exact path="/documents" component={AdminAddDocuments}/>
                        <Route exact path="/emprunts" component={Emprunts} />
                        <Route exact path="/retourEmprunt" component={RetourEmprunt}/>
                        <Route exact path="/user" component={ChoixUser}/>
                    </Switch>
                </div>
            </Router>
        </div>

    );
}

export default App;
