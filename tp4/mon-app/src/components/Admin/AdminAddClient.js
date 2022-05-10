import React from "react";
import FooterAdmin from "./FooterAdmin";
import {useState, useEffect} from "react";

const AdminAddClient = () => {

    const [nom, setNom] = useState('')
    const [prenom, setPrenom] = useState('')
    const [adresse, setAdresse] = useState('')
    const [clients, setClients] = useState([])


    const onSubmit = (e) => {
        e.preventDefault()

        if (!nom) {
            alert('Ajouter le nom')
            return
        } else if (!prenom) {
            alert('Ajouter le prenom')
            return
        } else if (!adresse) {
            alert('Ajouter le adresse')
            return
        }
        const client = {nom, prenom, adresse}
        fetch("http://localhost:2002/todos/add", {
            method: "POST",
            headers: {"Content-type": "application/json"},
            body: JSON.stringify(client)
        }).then(() => {
            console.log("new Client added")
        })
        setNom('')
        setPrenom('')
        setAdresse('')
    }

    useEffect(() => {
        const getClients = async () => {
            const tasksFromServer = await fetchClient()
            setClients(tasksFromServer)

        }
        getClients()
    }, [])

    const fetchClient = async () => {
        const res = await fetch('http://localhost:2002/todos/getAll')
        const data = await res.json()
        return data
    }


    return (
        <div>
            <div className="container">
                <div className="textBienvenue">
                    <h2>Vous pouvez voir tous les clients et on ajoutait</h2>
                </div>
                <form className='add-form' onSubmit={onSubmit}>
                    <div className='form-control'>
                        <label style={{margin: "5px"}}>Nom</label>
                        <input type='text' placeholder='nomClient'
                               value={nom}
                               onChange={(e) => setNom(e.target.value)}/>
                    </div>
                    <div className='form-control'>
                        <label style={{margin: "5px"}}>Prenom</label>
                        <input type='text' placeholder='prenomClient'
                               value={prenom}
                               onChange={(e) => setPrenom(e.target.value)}/>
                    </div>
                    <div className='form-control'>
                        <label style={{margin: "5px"}}>Address</label>
                        <input type='text' placeholder='adresse'
                               value={adresse}
                               onChange={(e) => setAdresse(e.target.value)}/>
                    </div>
                    <input type='submit' value='Save CLient' className='btn btn-block'/>
                </form>
                <div style={{margin: "5px"}}>
                    Liste de Clients :
                    <br/>
                    {clients.map((client) =>(
                        <div key={client.id}>
                            {client.nom}
                            {client.prenom}
                            {client.adresse}
                        </div>
                    ))}
                </div>
            </div>
            <FooterAdmin/>
        </div>


    )
}

export default AdminAddClient
