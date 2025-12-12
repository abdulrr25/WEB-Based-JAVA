import { useEffect, useState } from "react";

export function ProductDetails(){
    const param=useParams();
    const [prod,setProd]=useState({});
    useEffect(()=>{
        const pid=param.pid;
        ProductService.getProductById(pid)
        .then((response)=>{
            setProd({...response.data});
        })
        .catch()
    },[param.pid])
    return(
        <div>
            <div className="card" style={{"width": "18rem"}}>
            <div className="card-body">
            <h3 class="card-title">Pname:{prod.pname}</h3>
            <h3 class="card-subtitle mb-2 text-muted">Price: {prod.price}</h3>
            <h3 class="card-text">Qty: {prod.qty}</h3>
            <h3 class="card-text">MfgDate: {prod.mfgdate}</h3>
            <h3 class="card-text">Cid: {prod.cid}</h3>

        </div>
        </div>
        </div>
    )
}