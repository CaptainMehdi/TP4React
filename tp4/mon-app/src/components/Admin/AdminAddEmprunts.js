import React, {useEffect, useState} from "react";
import FooterAdmin from "./FooterAdmin";

const AdminAddEmprunts = () => {
    const [emprunts,setEmprunts] = useState([])
    const [client, setClients] = useState('')
    const [document, setDocuments] = useState('')

    const onSubmit = (e) => {
        e.preventDefault()

        if (!client) {
            alert('Ajouter le identifiant Client')
            return
        } else if (!document) {
            alert('Ajouter le identifiant Document')
            return
        }
        const emprunt = {client,document}
        console.log(emprunt)
        fetch('http://localhost:2002/todos/addEmprunt', {
            method: "POST",
            headers: {"Content-type": "application/json"},
            body: JSON.stringify(emprunt)
        }).then(() => {
            console.log("new emprunt added")
        })
        setClients('')
        setDocuments('')
    }


    useEffect(() => {
        const getEmprunt = async () => {
            const empruntFromServer = await fetchEmprunt()
            setEmprunts(empruntFromServer)

        }
        getEmprunt()
    }, [])

    const fetchEmprunt = async () => {
        const res = await fetch('http://localhost:2002/todos/getAllEmprunt')
        const data = await res.json()
        return data
    }



    return (
        <div>
            <div className="container">
                <div className="textBienvenue">
                    <h2>Vous pouvez voir tous les emprunts et en ajouter</h2>
                </div>
                <form className='add-form' onSubmit={onSubmit}>
                    <div className='form-control'>
                        <label style={{margin: "5px"}}>Client</label>
                        <input type='text' placeholder='nomClient'
                               value={client}
                               onChange={(e) => setClients(e.target.value)}/>
                    </div>
                    <div className='form-control'>
                        <label style={{margin: "5px"}}>Document</label>
                        <input type='text' placeholder='prenomClient'
                               value={document}
                               onChange={(e) => setDocuments(e.target.value)}/>
                    </div>
                    <input type='submit' value='Save CLient' className='btn btn-block'/>
                </form>

                <div>
                    {emprunts.map((emprunt)=>(
                        <div className="tableElement" key={emprunt.id}>
                            <h5>Emprunt Id: {emprunt.id}</h5>
                            <h5>Client Id: {emprunt.client}</h5>
                            <h5>Document Id: {emprunt.document}</h5>

                        </div>
                    ))}
                </div>

            </div>
            <FooterAdmin/>
        </div>


    )
}
export default AdminAddEmprunts