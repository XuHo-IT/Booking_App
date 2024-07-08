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
        <body class="main-color-web">
        <!-- Spinner Start -->
        <div
            id="spinner"
            class="show bg-white position-fixed translate-middle w-100 vh-100 top-50 start-50 d-flex align-items-center justify-content-center"
            >
            <div
                class="spinner-border text-primary"
                style="width: 3rem; height: 3rem"
                role="status"
                >
                <span class="sr-only">Loading...</span>
            </div>
        </div>
        <!-- Spinner End -->

        <!-- Topbar Start -->
        <div class="container-fluid gradient-1 px-5 d-none d-lg-block">
            <div class="row gx-0">
                <div class="col-lg-8 text-center text-lg-start mb-2 mb-lg-0">
                    <div class="d-inline-flex align-items-center" style="height: 45px">
                        <small class="me-3 text-light"
                               ><i class="fa fa-map-marker-alt me-2"></i>Khu ?ô th? FPT City, Ng?
                            Hành S?n, ?à N?ng</small
                        >
                        <small class="me-3 text-light"
                               ><i class="fa fa-phone-alt me-2"></i>+0352736104</small
                        >
                        <small class="text-light"
                               ><i class="fa fa-envelope-open me-2"></i
                            >hoantxde180175@fpt.edu.vn</small
                        >
                    </div>
                </div>
                <div class="col-lg-4 text-center text-lg-end">
                    <div class="d-inline-flex align-items-center" style="height: 45px">
                        <a
                            class="btn btn-sm btn-outline-light btn-sm-square rounded-circle me-2"
                            href="https://x.com/HuyLongDev"
                            rel="noopener"
                            target="_blank"
                            ><i class="fab fa-twitter fw-normal"></i
                            ></a>
                        <a
                            class="btn btn-sm btn-outline-light btn-sm-square rounded-circle me-2"
                            href="https://www.facebook.com/hoa.ngotran.986"
                            rel="noopener"
                            target="_blank"
                            ><i class="fab fa-facebook-f fw-normal"></i
                            ></a>
                        <a
                            class="btn btn-sm btn-outline-light btn-sm-square rounded-circle me-2"
                            href="https://www.linkedin.com/in/thành-nguy?n-lê-??ng-834bb8285/"
                            rel="noopener"
                            target="_blank"
                            ><i class="fab fa-linkedin-in fw-normal"></i
                            ></a>
                        <a
                            class="btn btn-sm btn-outline-light btn-sm-square rounded-circle me-2"
                            href="https://www.instagram.com/_.xuho._/"
                            rel="noopener"
                            target="_blank"
                            ><i class="fab fa-instagram fw-normal"></i
                            ></a>
                        <a
                            class="btn btn-sm btn-outline-light btn-sm-square rounded-circle"
                            href="https://github.com/huylongdev"
                            rel="noopener"
                            target="_blank"
                            ><i class="fab fa-github fw-normal"></i
                            ></a>
                    </div>
                </div>
            </div>
        </div>
        <!-- Topbar End -->

        <!-- Navbar & Hero Start -->
        <div class="container-fluid position-relative p-0">
            <nav
                class="navbar navbar-expand-lg navbar-light px-4 px-lg-5 py-3 py-lg-0"
                >
                <a href="" class="navbar-brand p-0">
                    <h1 class="m-0">
                        <div class="wrapper invert">
                            <span data-text="FPT"></span>
                            <span data-text="PARADISE"></span>
                        </div>
                    </h1>
                    <!-- <img src="img/logo.png" alt="Logo"> -->
                </a>
                <button
                    class="navbar-toggler"
                    type="button"
                    data-bs-toggle="collapse"
                    data-bs-target="#navbarCollapse"
                    >
                    <span class="fa fa-bars"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarCollapse">
                    <div class="navbar-nav ms-auto py-0">
                        <a href="index.jsp" class="nav-item nav-link active">Home</a>
                       
                        <a href="roomadmin.jsp" class="nav-item nav-link">Rooms</a>
                       
                       
                    </div>
                </div >
                <div class="nav-item dropdown">
                    <a
                        href="#"
                        class="nav-link dropdown-toggle"
                        data-toggle="dropdown"
                        >
                        <i class="fas fa-user"></i>
                    </a>
                    <div class="dropdown-menu m-0">
                        <a href="LogoutController" data-toggle="modal" data-target="#exampleModal" class="dropdown-item">Logout</a>
                        <a href="#" class="drodown-item">Bill</a>
                    </div>
                </div>
        </div>
       
    </nav>
    <div class="container-fluid bg-primary py-5 mb-5 hero-header">
        <div class="container py-5">
            <div class="row justify-content-center py-5">
                <div class="col-lg-10 pt-lg-5 mt-lg-5 text-center">
                    <h1 class="display-3 text-white mb-3 animated slideInDown">
                        Enjoy Your Vacation With FPT Villas
                    </h1>
                    <p class="fs-4 text-white mb-4 animated slideInDown">
                        Modern villas, seamlessly blending with nature.
                    </p>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Navbar & Hero End -->
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
                            <form action="DeleteRoomController?id=<%=b.getRoomId()%>" method="post">
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
