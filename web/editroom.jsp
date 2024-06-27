<!DOCTYPE html>
<%@page import="DAO.RoomDAO"%>
<%@page import="DBConnect.DBConnect"%>
<%@page import="Model.Room"%>
<%@page import="java.util.List"%>
<%@page isELIgnored="false"%>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <title>Tourist - Travel Agency HTML Template</title>
        <meta content="width=device-width, initial-scale=1.0" name="viewport" />
        <meta content="" name="keywords" />
        <meta content="" name="description" />

        <!-- Favicon -->
        <link href="./img/favicon.png" rel="icon" />

        <!-- Google Web Fonts -->
        <link rel="preconnect" href="https://fonts.googleapis.com" />
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
        <link
            href="https://fonts.googleapis.com/css2?family=Heebo:wght@400;500;600&family=Nunito:wght@600;700;800&display=swap"
            rel="stylesheet"
            />

        <!-- Bootstrap CSS -->
        <link
            href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
            rel="stylesheet"
            />
        <!-- Icon Font Stylesheet -->
        <link
            href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css"
            rel="stylesheet"
            />
        <link
            href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css"
            rel="stylesheet"
            />

        <!-- Libraries Stylesheet -->
        <link href="lib/animate/animate.min.css" rel="stylesheet" />
        <link href="lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet" />
        <link
            href="lib/tempusdominus/css/tempusdominus-bootstrap-4.min.css"
            rel="stylesheet"
            />


        <!-- Customized Bootstrap Stylesheet -->
        <link href="css/bootstrap.min.css" rel="stylesheet" />

        <!-- Template Stylesheet -->
        <link href="css/style.css" rel="stylesheet" />
    </head>
    <body>
        <%@include file="header.jsp"%>
        <div class="container">
            <div class="row">
                <div class="col-md-6 offset-md-3">
                    <div class="card">
                        <div class="card-header">
                            <h3 class="text-center">Edit Book</h3>
                        </div>
                        <div class="card-body">
                            <%
                                RoomDAO dao = new RoomDAO(DBConnect.getConn());
                                int id = Integer.parseInt(request.getParameter("id"));
                                Room b = dao.getRoomById(id);
                            %>
                            <form action="EditRoom?id=<%=b.getRoomId()%>" method="post">
                               
                                <div class="mb-3">
                                    <label for="name" class="form-label">Room Type</label>
                                    <input type="text" class="form-control" id="type" name="type" value="<%=b.getRoomtype()%>">
                                </div>
                                <div class="mb-3">
                                    <label for="author" class="form-label">Capacity</label>
                                    <input type="text" class="form-control" id="capacity" name="capacity" value="<%=b.getCapacity()%>">
                                </div>
                                <div class="mb-3">
                                    <label for="price" class="form-label">Price</label>
                                    <input type="number" class="form-control" id="price" name="price" value="<%=b.getPrice()%>">
                                </div>
                                <div class="mb-3">
                                    <label for="messages" class="form-label">Messages</label>
                                    <input type="text" class="form-control" id="messages" name="messages" value="<%=b.getMessages()%>">
                                </div>
                                <div class="mb-3">
                                    <label for="status" class="form-label">Room Status</label>
                                    <select class="form-select form-control" id="status" name="status">
                                        <option selected>Choose...</option>
                                        <% if ("Available".equals(b.getStatus())) {%> 
                                        <option value="Available">Available</option>
                                        <option value="Unavailable">Unavailable</option>
                                        <%
                                        } else {%>
                                        <option value="Available">Available</option>
                                        <option value="Unavailable">Unavailable</option>
                                        <%}
                                        %>
                                    </select>
                                </div> 
                                <div class="text-center">
                                    <button type="submit" class="btn btn-primary">Edit Room</button>
                                </div>
                            </form>
                            <form action="DeleteRoomController?id=<%=b.getRoomId()%>" method="get">
                                <button type="submit" class="btn btn-secondary mt-3" >Delete Room</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div>
            <%@include file="footer.jsp" %>

            <!-- Back to Top -->
            <a href="#" class="btn btn-lg btn-primary btn-lg-square back-to-top"><i class="bi bi-arrow-up"></i></a>


            <!-- JavaScript Libraries -->
            <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
            <script src="lib/wow/wow.min.js"></script>
            <script src="lib/easing/easing.min.js"></script>
            <script src="lib/waypoints/waypoints.min.js"></script>
            <script src="lib/owlcarousel/owl.carousel.min.js"></script>
            <script src="lib/tempusdominus/js/moment.min.js"></script>
            <script src="lib/tempusdominus/js/moment-timezone.min.js"></script>
            <script src="lib/tempusdominus/js/tempusdominus-bootstrap-4.min.js"></script>

            <!-- Template Javascript -->
            <script src="js/main.js"></script>
    </body>
</html>
