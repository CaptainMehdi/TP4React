import React from "react";
import FooterAdmin from "./FooterAdmin";
import {useState} from "react";

const AdminAddClient = ({onAdd}) => {

    const [nom, setNom] = useState('')
    const [prenom, setPrenom] = useState('')
    const [adresse, setAdresse] = useState('')

    const onSubmit = (e) => {
        e.preventDefault()

        if (!nom) {
            alert('Ajouter le nom')
            return
        }else if(!prenom){
            alert('Ajouter le prenom')
            return
        }else if(!adresse){
            alert('Ajouter le adresse')
            return
        }

        onAdd({nom, prenom, adresse})
        setNom('')
        setPrenom('')
        setAdresse('')
    }
    return (
        <div>
            <div className="container">
                <div className="textBienvenue">
                    <h2>Vous pouvez voir tous les clients et on ajoutait</h2>
                </div>
                <form className='add-form' onSubmit={onSubmit}>
                    <div className='form-control'>
                        <label style={{margin:"5px"}}>Nom</label>
                        <input type='text' placeholder='nomClient'
                               value={nom}
                               onChange={(e) => setNom(e.target.value)}/>
                    </div>
                    <div className='form-control'>
                        <label style={{margin:"5px"}}>Prenom</label>
                        <input type='text' placeholder='prenomClient'
                               value={prenom}
                               onChange={(e) => setPrenom(e.target.value)}/>
                    </div>
                    <div className='form-control'>
                        <label style={{margin:"5px"}}>Address</label>
                        <input type='text' placeholder='adresse'
                               value={adresse}
                               onChange={(e) => setAdresse(e.target.value)}/>
                    </div>
                    <input type='submit' value='Save CLient' className='btn btn-block'/>
                </form>
                <div style={{margin:"5px"}}>
                    Liste de Clients :
                    <br/>
                </div>
            </div>
            <FooterAdmin/>
        </div>


    )
}

export default AdminAddClient
