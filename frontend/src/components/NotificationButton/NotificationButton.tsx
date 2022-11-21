import axios from "axios";
import icon from "../../assets/notification-icon.svg";
import { BASE_URL } from "../../utils/request";
import "./styles.css";

type props = {
  saleId: number;
}

function hadleClick ( id : number) {
  axios(`${BASE_URL}sales/${id}/notification`)
  .then(response => console.log("success "+response.data))
  .catch((err)=> console.log(err));
}


export const NotificationButton = ({saleId} : props) => {
  
 

  return (
    <div className="dsmeta-red-btn" onClick={() => hadleClick(saleId)}>
      <img src={icon} alt="Notification BTN" />
    </div>
  );
};
