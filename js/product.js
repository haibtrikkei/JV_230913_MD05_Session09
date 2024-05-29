let api_url = "http://localhost:8080/api/v1/product"
const getProducts = async()=>{    
    let res = await fetch(api_url);
    let data = await res.json();
    let html = "";
    for(let i=0;i<data.length;i++){
        let p = data[i];
        html +=`<tr>
                    <td>${p.proId}</td>
                    <td>${p.proName}</td>
                    <td>${p.producer}</td>
                    <td>${p.yearMaking}</td>
                    <td>${p.price}</td>
                    <td>
                        <button onclick="showProduct(${p.proId})">Edit</button>
                        <button onclick="deleteProduct(${p.proId})">Delete</button>
                    </td>
                </tr>`
    }
    document.getElementById("list_product").innerHTML=html;
}

getProducts();

let button = document.getElementById("add")
button.addEventListener('click',saveProduct)

async function saveProduct(){
    //lay du lieu xuong
    let proName = document.getElementById('proName').value;
    let producer = document.getElementById('producer').value;
    let yearMaking = document.getElementById('yearMaking').value;
    let price = document.getElementById('price').value;

    let action = document.getElementById("add").innerText;
    if(action==="Add"){
        //chuyen dl ve json
        let data = JSON.stringify({proName,producer,yearMaking,price});        
        //goi api de save du lieu vao datababse
        await fetch(api_url,{method:"post",headers:{"Content-Type":"application/json"},body:data}).then(res=>getProducts);
    }else{
        let proId = document.getElementById('proId').value;
        //chuyen dl ve json
        let data = JSON.stringify({proId,proName,producer,yearMaking,price});

        //goi api de save du lieu vao datababse
        await fetch(api_url+"/"+proId,{method:"put",headers:{"Content-Type":"application/json"},body:data}).then(res=>getProducts);
        document.getElementById("add").innerText="Add";
    }    
}

async function showProduct(proId){
    //goi api de lay du lieu ve
    let res = await fetch(api_url+"/"+proId);
    let data = await res.json();
    document.getElementById("proId").value = data.proId;
    document.getElementById("proName").value = data.proName;
    document.getElementById("producer").value = data.producer;
    document.getElementById("yearMaking").value = data.yearMaking;
    document.getElementById("price").value = data.price;
    document.getElementById("add").innerText="Edit";
}

async function deleteProduct(proId){
   await fetch(api_url+"/"+proId,{method:"delete"}).then(res=>getProducts);
    // let data = await res.json();
    // document.getElementById("result").value = "Đã xóa sản phẩm: "+data.proName;
}